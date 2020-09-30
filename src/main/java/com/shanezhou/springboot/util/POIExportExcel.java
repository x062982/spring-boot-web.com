package com.shanezhou.springboot.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author ShaneZhou
 * @Since 2020/9/3 周四
 */
public class POIExportExcel {

    public static final int colWidth = 12;

    private static int index = 0;

    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {

        File outFile = new File("C:\\Users\\shanezhou\\Desktop\\testExcel1.xlsx");
        FileOutputStream fos = null;
        POIExportExcel excel = new POIExportExcel();
        XSSFWorkbook workbook = excel.exportExcel();
        try {
            fos = new FileOutputStream(outFile);
            workbook.write(fos);
            //fos.flush();
            System.out.println("导出成功！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        new Thread(() -> {
            for (long i = 0; i < Long.MAX_VALUE; i++) {
                if (i == Integer.MAX_VALUE) {
                    return;
                }
                index++;
            }
            System.out.println(index == Integer.MAX_VALUE);
        }).start();
        return index;
    }
    public XSSFWorkbook exportExcel() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 设置字体
        Font titleFont = workbook.createFont();
        //titleFont.setBold(true);
        titleFont.setFontHeight((short)(16 * 20));
        titleFont.setFontName("华文中宋");

        // 设置单元格样式
        XSSFCellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setFont(titleFont);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        titleStyle.setBorderTop(BorderStyle.THIN);
        titleStyle.setBorderBottom(BorderStyle.THIN);
        titleStyle.setBorderLeft(BorderStyle.THIN);
        titleStyle.setBorderRight(BorderStyle.THIN);

        Font textFont = workbook.createFont();
        textFont.setFontHeight((short)(20 * 12));
        textFont.setFontName("华文中宋");

        XSSFCellStyle textStyle = workbook.createCellStyle();
        textStyle.setBorderTop(BorderStyle.THIN);
        textStyle.setBorderBottom(BorderStyle.THIN);
        textStyle.setBorderRight(BorderStyle.THIN);
        textStyle.setBorderLeft(BorderStyle.THIN);
        textStyle.setAlignment(HorizontalAlignment.CENTER);
        textStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        textStyle.setFont(textFont);

        XSSFCellStyle style1 = workbook.createCellStyle();
        style1.setBorderTop(BorderStyle.THIN);
        style1.setBorderBottom(BorderStyle.THIN);
        style1.setBorderRight(BorderStyle.THIN);
        style1.setBorderLeft(BorderStyle.THIN);
        style1.setAlignment(HorizontalAlignment.RIGHT);
        style1.setVerticalAlignment(VerticalAlignment.CENTER);
        style1.setFont(textFont);

        XSSFSheet sheet = workbook.createSheet();

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 7));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 7));
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 5));
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 6, 7));
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 7));
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 1));
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 2, 3));
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 4, 5));
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 6, 7));
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 1));
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 2, 3));
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 0, 1));
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 2, 3));
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 5, 7));
        sheet.addMergedRegion(new CellRangeAddress(7, 7, 0, 1));
        sheet.addMergedRegion(new CellRangeAddress(7, 7, 2, 3));
        sheet.addMergedRegion(new CellRangeAddress(8, 8, 0, 1));
        sheet.addMergedRegion(new CellRangeAddress(8, 8, 2, 3));
        sheet.addMergedRegion(new CellRangeAddress(9, 9, 0, 1));
        sheet.addMergedRegion(new CellRangeAddress(9, 9, 2, 3));
        sheet.addMergedRegion(new CellRangeAddress(10, 10, 0, 1));
        sheet.addMergedRegion(new CellRangeAddress(10, 10, 2, 7));
        sheet.addMergedRegion(new CellRangeAddress(11, 11, 0, 2));
        sheet.addMergedRegion(new CellRangeAddress(11, 11, 3, 5));
        sheet.addMergedRegion(new CellRangeAddress(12, 15, 0, 0));
        sheet.addMergedRegion(new CellRangeAddress(12, 12, 1, 2));
        sheet.addMergedRegion(new CellRangeAddress(12, 12, 3, 5));
        sheet.addMergedRegion(new CellRangeAddress(13, 13, 1, 2));
        sheet.addMergedRegion(new CellRangeAddress(13, 13, 3, 5));
        sheet.addMergedRegion(new CellRangeAddress(14, 14, 1, 2));
        sheet.addMergedRegion(new CellRangeAddress(14, 14, 3, 5));
        sheet.addMergedRegion(new CellRangeAddress(15, 15, 1, 2));
        sheet.addMergedRegion(new CellRangeAddress(15, 15, 3, 5));
        sheet.addMergedRegion(new CellRangeAddress(16, 18, 0, 7));
        sheet.addMergedRegion(new CellRangeAddress(19, 19, 0, 2));
        sheet.addMergedRegion(new CellRangeAddress(19, 19, 3, 7));
        sheet.addMergedRegion(new CellRangeAddress(20, 20, 0, 2));
        sheet.addMergedRegion(new CellRangeAddress(20, 20, 3, 5));
        sheet.addMergedRegion(new CellRangeAddress(20, 20, 6, 7));

        sheet.setDefaultRowHeight((short)700);
        for (int i = 0; i < 8; i++) {
            sheet.setColumnWidth(i, 256 * colWidth);
        }
        sheet.setColumnWidth(2, 256 * 10);
        sheet.setColumnWidth(3, 256 * 10);
        sheet.setColumnWidth(4, 256 * 14);
        sheet.setColumnWidth(5, 256 * 16);
        sheet.setColumnWidth(7, 256 * 16);

        File file = new File("C:\\Users\\shanezhou\\Desktop\\1.jpg");
        ByteArrayOutputStream baos = createImage(file);
        // 创建一个画图
        XSSFDrawing patriarch = sheet.createDrawingPatriarch();
        /**  创建图片导入位置
         * 前四个参数是控制图片在单元格的位置，分别是图片距离单元格left，top，right，bottom的像素距离
         * 后四个参数，前两个表示图片左上角所在的cellNum和 rowNum，
         * 后两个参数对应的表示图片右下角所在的cellNum和 rowNum，
         * excel中的cellNum和rowNum的index都是从0开始的
         */
        XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 0, 0, 0, 0, 1, 2);
        patriarch.createPicture(anchor, workbook.addPicture(baos.toByteArray(),
                XSSFWorkbook.PICTURE_TYPE_JPEG));

        Row row = sheet.createRow(0);
        for (int i = 0; i < 6; i++) {
            row.createCell(i);
            row.getCell(i).setCellStyle(titleStyle);
        }
        row.getCell(0).setCellValue("四特酒有限责任公司检测中心");

        Cell cell = row.createCell(6);
        cell.setCellStyle(style1);
        cell.setCellValue("STJC-JJ-21-1");

        Row row1 = sheet.createRow(1);
        Cell cell1 = row1.createCell(0);
        for (int i = 0; i < 8; i++) {
            row1.createCell(i);
            row1.getCell(i).setCellStyle(titleStyle);
        }
        cell1.setCellValue("品   评  报  告");

        for (int i = 2; i < 21; i++) {
            sheet.createRow(i);
            for (int j = 0; j < 8; j++) {
                sheet.getRow(i).createCell(j).setCellStyle(textStyle);
            }
        }
        sheet.getRow(2).getCell(0)
                .setCellValue("地址：中国江西省宜春市樟树市药都北大道11号，邮编：331200");
        sheet.getRow(2).getCell(6).setCellValue("出证日期：");
        sheet.getRow(2).getCell(7).setCellValue("");
        sheet.getRow(3).getCell(0)
                .setCellValue("电话：（Tel):0086-795-7361907   传真（Fax):0086-795-7361576");
        sheet.getRow(4).getCell(0).setCellValue("样品名称");
        sheet.getRow(4).getCell(2).setCellValue("1");
        sheet.getRow(4).getCell(4).setCellValue("规格型号");
        sheet.getRow(4).getCell(6).setCellValue("/");
        sheet.getRow(5).getCell(0).setCellValue("样品编号");
        sheet.getRow(5).getCell(2).setCellValue("1");
        sheet.getRow(5).getCell(4).setCellValue("样品包装/状态");
        sheet.getRow(5).getCell(5).setCellValue("1");
        sheet.getRow(5).getCell(6).setCellValue("样品来源");
        sheet.getRow(5).getCell(7).setCellValue("1");
        sheet.getRow(6).getCell(0).setCellValue("生产日期(批号)");
        sheet.getRow(6).getCell(2).setCellValue("1");
        sheet.getRow(6).getCell(4).setCellValue("检测依据");
        sheet.getRow(6).getCell(5).setCellValue("1");
        sheet.getRow(7).getCell(0).setCellValue("总产量");
        sheet.getRow(7).getCell(2).setCellValue("/");
        sheet.getRow(7).getCell(4).setCellValue("内检员");
        sheet.getRow(7).getCell(5).setCellValue("/");
        sheet.getRow(7).getCell(6).setCellValue("生产线号");
        sheet.getRow(7).getCell(7).setCellValue("/");
        sheet.getRow(8).getCell(0).setCellValue("送样人");
        sheet.getRow(8).getCell(2).setCellValue("1");
        sheet.getRow(8).getCell(4).setCellValue("收样人");
        sheet.getRow(8).getCell(5).setCellValue("1");
        sheet.getRow(8).getCell(6).setCellValue("样品数量");
        sheet.getRow(8).getCell(7).setCellValue("1");
        sheet.getRow(9).getCell(0).setCellValue("送样日期");
        sheet.getRow(9).getCell(2).setCellValue("1");
        sheet.getRow(9).getCell(4).setCellValue("收样日期");
        sheet.getRow(9).getCell(5).setCellValue("1");
        sheet.getRow(9).getCell(6).setCellValue("检验日期");
        sheet.getRow(9).getCell(7).setCellValue("1");
        sheet.getRow(10).getCell(0).setCellValue("判定标准");
        sheet.getRow(10).getCell(2).setCellValue("1");
        sheet.getRow(11).getCell(0).setCellValue("检测项目");
        sheet.getRow(11).getCell(3).setCellValue("技术要求");
        sheet.getRow(11).getCell(6).setCellValue("检测结果");
        sheet.getRow(11).getCell(7).setCellValue("单项判定");
        sheet.getRow(12).getCell(0).setCellValue("感官检验");
        sheet.getRow(12).getCell(1).setCellValue("色泽");
        sheet.getRow(12).getCell(3).setCellValue("清亮透明、无悬浮物、无沉淀");
        sheet.getRow(12).getCell(4).setCellValue("");
        sheet.getRow(12).getCell(5).setCellValue("");
        sheet.getRow(13).getCell(1).setCellValue("香气");
        sheet.getRow(13).getCell(3).setCellValue("香气幽雅舒适、浓、清、酱兼而有之、诸香协调");
        sheet.getRow(13).getCell(4).setCellValue("");
        sheet.getRow(13).getCell(5).setCellValue("");
        sheet.getRow(14).getCell(1).setCellValue("口味");
        sheet.getRow(14).getCell(3).setCellValue("入口绵甜、酒体丰润、后味绵长净爽");
        sheet.getRow(14).getCell(4).setCellValue("");
        sheet.getRow(14).getCell(5).setCellValue("");
        sheet.getRow(15).getCell(1).setCellValue("风格");
        sheet.getRow(15).getCell(3).setCellValue("具有本品风格");
        sheet.getRow(15).getCell(4).setCellValue("");
        sheet.getRow(15).getCell(5).setCellValue("");
        sheet.getRow(16).getCell(0).setCellValue("以下空白");
        sheet.getRow(19).getCell(0).setCellValue("检验结论");
        sheet.getRow(19).getCell(3).setCellValue("1");
        sheet.getRow(20).getCell(0).setCellValue("编制：");
        sheet.getRow(20).getCell(1).setCellValue("");
        sheet.getRow(20).getCell(3).setCellValue("审核：");
        sheet.getRow(20).getCell(5).setCellValue("");
        sheet.getRow(20).getCell(6).setCellValue("批准：");
        sheet.getRow(20).getCell(7).setCellValue("");



        return workbook;
    }

    public ByteArrayOutputStream createImage(File image) {
        BufferedImage bufferedImage = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            bufferedImage = ImageIO.read(image);
            ImageIO.write(bufferedImage, "JPG", baos);
            //baos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return baos;
    }
}
