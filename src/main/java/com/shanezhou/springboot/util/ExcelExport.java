package com.shanezhou.springboot.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author ShaneZhou
 * @since 2020/9/3 周四
 */
public class ExcelExport {

    public static void main(String[] args) {
        //FileOutputStream fos = null;
        //try {
        //    fos = new FileOutputStream(new File("text.xlsx"));
        //    ExcelExport export = new ExcelExport();
        //    XSSFWorkbook workbook = export.createFinishBook();
        //    workbook.write(fos);
        //    System.out.println("导出成功！");
        //} catch (FileNotFoundException e) {
        //    // TODO Auto-generated catch block
        //    e.printStackTrace();
        //} catch (IOException e) {
        //    // TODO Auto-generated catch block
        //    e.printStackTrace();
        //} finally {
        //    try {
        //        fos.close();
        //    } catch (IOException e) {
        //        // TODO Auto-generated catch block
        //        e.printStackTrace();
        //    }
        //}
        
    }

    private static final short rowHeight = 650;

    public XSSFWorkbook createFinishBook() {
        int rowNum = 21;
        XWorkbook workbook = new XWorkbook(rowNum);
        //XSSFWorkbook workbook = new XSSFWorkbook();
        Font textFont = workbook.getFont();
        Font titleFont = workbook.getFont(16);
        XSSFSheet sheet = workbook.createSheet();

        sheet.setDefaultRowHeight(rowHeight);

        int colNum = 8;
        workbook.setColumnWidth(colNum, new int[]{3000, 3000, 2500, 2500, 3500, 4000, 3000, 4000});

        XSSFCellStyle textStyle = workbook.getCellStyle();
        textStyle.setFont(textFont);

        XSSFCellStyle titleStyle = workbook.getCellStyle();
        titleStyle.setFont(titleFont);

        for (int i = 0; i < rowNum; i++) {
            //sheet.createRow(i);
            for (int j = 0; j < colNum; j++) {
                sheet.getRow(i).createCell(j);
            }
        }

        // 合并单元格
        //int rowIndex = 0;
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, 5));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 6, 7));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 0, 7));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, 5));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 6, 7));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 0, 7));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, 1));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 2, 3));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 4, 5));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 6, 7));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, 1));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 2, 3));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, 1));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 2, 3));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 5, 7));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, 1));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 2, 3));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, 1));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 2, 3));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, 1));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 2, 3));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, 1));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 2, 7));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, 2));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 3, 5));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex + 3, 0, 0));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 1, 2));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 3, 5));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 1, 2));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 3, 5));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 1, 2));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 3, 5));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 1, 2));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 3, 5));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex += 2, 0, 7));
        //sheet.addMergedRegion(new CellRangeAddress(++rowIndex, rowIndex, 0, 2));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 3, 7));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, 2));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 3, 5));
        //sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex++, 6, 7));

        //rowIndex = 0;
        //XSSFRow row = sheet.getRow(rowIndex);
        //row.getCell(0).setCellStyle(titleStyle);
        //row.getCell(0).setCellValue("四特酒有限责任公司检测中心");
        //row.getCell(6).setCellStyle(titleStyle);
        //row.getCell(6).setCellValue("STJC-JJ-21-1");
        //
        //sheet.getRow(++rowIndex).getCell(0).setCellValue("品   评   报   告");
        //
        //sheet.getRow(++rowIndex).getCell(0)
        //        .setCellValue("地址：中国江西省宜春市樟树市药都北大道11号，邮编：331200");
        //sheet.getRow(rowIndex).getCell(6).setCellValue("出证日期：");
        //sheet.getRow(rowIndex).getCell(7).setCellValue("");
        //
        //sheet.getRow(++rowIndex).getCell(0)
        //        .setCellValue("电话：（Tel):0086-795-7361907   传真（Fax):0086-795-7361576");
        //
        //sheet.getRow(++rowIndex).getCell(0).setCellValue("样品名称");
        //sheet.getRow(rowIndex).getCell(2).setCellValue("1");
        //sheet.getRow(rowIndex).getCell(4).setCellValue("规格型号");
        //sheet.getRow(rowIndex).getCell(6).setCellValue("/");
        //
        //sheet.getRow(++rowIndex).getCell(0).setCellValue("样品编号");
        //sheet.getRow(rowIndex).getCell(2).setCellValue("1");
        //sheet.getRow(rowIndex).getCell(4).setCellValue("样品包装/状态");
        //sheet.getRow(rowIndex).getCell(5).setCellValue("1");
        //sheet.getRow(rowIndex).getCell(6).setCellValue("样品来源");
        //sheet.getRow(rowIndex).getCell(7).setCellValue("1");
        //
        //sheet.getRow(++rowIndex).getCell(0).setCellValue("生产日期(批号)");
        //sheet.getRow(rowIndex).getCell(2).setCellValue("1");
        //sheet.getRow(rowIndex).getCell(4).setCellValue("检测依据");
        //sheet.getRow(rowIndex).getCell(5).setCellValue("1");
        //
        //sheet.getRow(++rowIndex).getCell(0).setCellValue("总产量");
        //sheet.getRow(rowIndex).getCell(2).setCellValue("/");
        //sheet.getRow(rowIndex).getCell(4).setCellValue("内检员");
        //sheet.getRow(rowIndex).getCell(5).setCellValue("/");
        //sheet.getRow(rowIndex).getCell(6).setCellValue("生产线号");
        //sheet.getRow(rowIndex).getCell(7).setCellValue("/");
        //
        //sheet.getRow(++rowIndex).getCell(0).setCellValue("送样人");
        //sheet.getRow(rowIndex).getCell(2).setCellValue("1");
        //sheet.getRow(rowIndex).getCell(4).setCellValue("收样人");
        //sheet.getRow(rowIndex).getCell(5).setCellValue("1");
        //sheet.getRow(rowIndex).getCell(6).setCellValue("样品数量");
        //sheet.getRow(rowIndex).getCell(7).setCellValue("1");
        //
        //sheet.getRow(++rowIndex).getCell(0).setCellValue("送样日期");
        //sheet.getRow(rowIndex).getCell(2).setCellValue("1");
        //sheet.getRow(rowIndex).getCell(4).setCellValue("收样日期");
        //sheet.getRow(rowIndex).getCell(5).setCellValue("1");
        //sheet.getRow(rowIndex).getCell(6).setCellValue("检验日期");
        //sheet.getRow(rowIndex).getCell(7).setCellValue("1");
        //
        //sheet.getRow(++rowIndex).getCell(0).setCellValue("判定标准");
        //sheet.getRow(rowIndex).getCell(2).setCellValue("1");
        //
        //sheet.getRow(++rowIndex).getCell(0).setCellValue("检测项目");
        //sheet.getRow(rowIndex).getCell(3).setCellValue("技术要求");
        //sheet.getRow(rowIndex).getCell(6).setCellValue("检测结果");
        //sheet.getRow(rowIndex).getCell(7).setCellValue("单项判定");
        //
        //sheet.getRow(++rowIndex).getCell(0).setCellValue("感官检验");
        //sheet.getRow(rowIndex).getCell(1).setCellValue("色泽");
        //sheet.getRow(rowIndex).getCell(3).setCellValue("清亮透明、无悬浮物、无沉淀");
        //sheet.getRow(rowIndex).getCell(4).setCellValue("");
        //sheet.getRow(rowIndex).getCell(5).setCellValue("");
        //
        //sheet.getRow(++rowIndex).getCell(1).setCellValue("香气");
        //sheet.getRow(rowIndex).getCell(3).setCellValue("香气幽雅舒适、浓、清、酱兼而有之、诸香协调");
        //sheet.getRow(rowIndex).getCell(4).setCellValue("");
        //sheet.getRow(rowIndex).getCell(5).setCellValue("");
        //
        //sheet.getRow(++rowIndex).getCell(1).setCellValue("口味");
        //sheet.getRow(rowIndex).getCell(3).setCellValue("入口绵甜、酒体丰润、后味绵长净爽");
        //sheet.getRow(rowIndex).getCell(4).setCellValue("");
        //sheet.getRow(rowIndex).getCell(5).setCellValue("");
        //
        //sheet.getRow(++rowIndex).getCell(1).setCellValue("风格");
        //sheet.getRow(rowIndex).getCell(3).setCellValue("具有本品风格");
        //sheet.getRow(rowIndex).getCell(4).setCellValue("");
        //sheet.getRow(rowIndex).getCell(5).setCellValue("");
        //
        //sheet.getRow(++rowIndex).getCell(0).setCellValue("以下空白");
        //
        //sheet.getRow(++rowIndex).getCell(0).setCellValue("检验结论");
        //sheet.getRow(rowIndex).getCell(3).setCellValue("1");
        //
        //sheet.getRow(++rowIndex).getCell(0).setCellValue("编制：");
        //sheet.getRow(rowIndex).getCell(1).setCellValue("");
        //sheet.getRow(rowIndex).getCell(3).setCellValue("审核：");
        //sheet.getRow(rowIndex).getCell(5).setCellValue("");
        //sheet.getRow(rowIndex).getCell(6).setCellValue("批准：");
        //sheet.getRow(rowIndex).getCell(7).setCellValue("");

        return workbook;
    }
}
