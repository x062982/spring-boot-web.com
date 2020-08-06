package com.shanezhou.springboot.service.impl;

import com.shanezhou.springboot.entity.Student;
import com.shanezhou.springboot.service.IStudentService;
import com.shanezhou.springboot.dao.StudentMapper;
import com.shanezhou.springboot.util.StringTools;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

/**
 * @Author ZhouWX
 * @CreateDate 2020/8/5 星期三
 */
@Service
public class StudentServiceImpl implements IStudentService {

    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";

    @Resource
    private StudentMapper mapper;

    /**
     * 导入Excel，兼容xls和xlsx
     *
     *  1.用HSSFWorkbook打开或者创建excel文件对象
     *  2.用HSSFWorkbook对象返回 或者 创建 sheet 对象
     *  3.用sheet对象返回 行对象，用行对象得到 Cell对象
     *  4.对cell对象读写
     *
     * @param myFile
     * @return
     */
    public Integer importExcel(MultipartFile myFile) throws Exception {
        Workbook workbook = null;
        // 获得文件名
        String fileName = myFile.getOriginalFilename();
        // 后缀xls
        if (fileName.endsWith(XLS)) {
            workbook = new HSSFWorkbook(myFile.getInputStream());
            // 后缀xlsx
        } else if (fileName.endsWith(XLSX)) {
            workbook = new XSSFWorkbook(myFile.getInputStream());
        } else {
            throw new IllegalArgumentException("该文件不是Excel文件");
        }
        // 得到sheet
        Sheet sheet = workbook.getSheet("Sheet1");
        // 获取最后一行，得到有多少行数
        int rows = sheet.getLastRowNum();
        if (rows == 0) {
            throw new Exception("没有数据");
        }
        Row row1 = sheet.getRow(0);
        for (int i = 1; i <= rows; i++) {
            // 从第二行开始
            Row row = sheet.getRow(i);
            if (row != null) {
                Student student = new Student();
                Class<Student> clazz = Student.class;
                short cells = row.getLastCellNum();
                for (short j = 0; j < cells; j++) {
                    String key = getCellValue(row1.getCell(j));
                    Object value = getCellValue(row.getCell(j));
                    String methodName = "set" + Character.toString(key.charAt(0)).toUpperCase() + key.substring(1);
                    Field field = clazz.getDeclaredField(key);
                    value = StringTools.stringToType(field.getType(), value.toString());

                    Method method = clazz.getDeclaredMethod(methodName, field.getType());
                    method.invoke(student, value);
                }

                int id = mapper.insert(student);
                System.out.println("id: " + id);
            }
        }

        return rows - 1;
    }

    public String getCellValue(Cell cell) {
        String value = "";
        if (cell != null) {
            // 判断数据类型
            switch (cell.getCellType()) {
                case NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        LocalDateTime date = cell.getLocalDateTimeCellValue();
                        if (date != null) {
                            value = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                        } else {
                            value = "";
                        }
                    } else {
                        value = new DecimalFormat("0").format(cell.getNumericCellValue());
                    }
                    break;
                case STRING:
                    value = cell.getStringCellValue();
                    break;
                case BOOLEAN:
                    value = cell.getBooleanCellValue() + "";
                    break;
                case FORMULA:   // 公式
                    value = cell.getCellFormula() + "";
                    break;
                case BLANK:
                    value = "";
                    break;
                case _NONE:
                    value = "";
                    break;
                case ERROR:
                    value = "非法字符";
                    break;
                default:
                    value = "未知类型";
                    break;
            }
        }
        return value.trim();
    }
}
