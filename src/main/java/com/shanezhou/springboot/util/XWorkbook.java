package com.shanezhou.springboot.util;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author ShaneZhou
 * @since 2020/9/3 周四
 */
public class XWorkbook extends XSSFWorkbook {

    private static volatile XWorkbook xworkbook;

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    private int fontSize = 12;
    private String fontName = "华文中宋";

    static {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet();
    }

    private XWorkbook() {
    }

    public XWorkbook(int rowNum) {
        for (int i = 0; i < rowNum; i++) {
            sheet.createRow(i);
        }
    }

    public static XWorkbook getInstance() {
        if (xworkbook == null) {
            synchronized(XSSFWorkbook.class) {
                xworkbook = new XWorkbook();
            }
        }
        return xworkbook;
    }

    public static XWorkbook getInstance(int rowNum) {
        if (xworkbook == null) {
            synchronized(XSSFWorkbook.class) {
                xworkbook = new XWorkbook(rowNum);
            }
        }
        return xworkbook;
    }

    public void setSheet(String sheetName) {
        this.sheet = workbook.createSheet(sheetName);
    }

    public XSSFSheet getSheet() {
        return this.sheet;
    }

    public void setColumnWidth(int colNum, int[] width) {
        if (colNum == 0 || width.length == 0) {
            return;
        }
        for (int i = 0, j = 0; i < colNum && j < width.length; i++, j++) {
            this.sheet.setColumnWidth(i, width[j]);
        }
    }

    public Font getFont() {
        Font font = workbook.createFont();
        font.setFontHeight((short)(this.fontSize * 20));
        font.setFontName(fontName);
        return font;
    }

    public Font getFont(int fontSize) {
        Font font = getFont();
        font.setFontHeight((short)(fontSize * 20));
        return font;
    }

    public Font getFont(String fontName, int fontSize) {
        Font font = getFont(fontSize);
        font.setFontName(fontName);
        return font;
    }

    public XSSFCellStyle getCellStyle() {
        XSSFCellStyle style = workbook.createCellStyle();
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    public XSSFCellStyle getCellStyle(HorizontalAlignment align) {
        XSSFCellStyle style = getCellStyle();
        style.setAlignment(align);
        return style;
    }

    public XSSFCellStyle getCellStyle(VerticalAlignment align) {
        XSSFCellStyle style = getCellStyle();
        style.setVerticalAlignment(align);
        return style;
    }

    public XSSFCellStyle getCellStyle(HorizontalAlignment hAlign, VerticalAlignment vAlign) {
        XSSFCellStyle style = getCellStyle();
        style.setVerticalAlignment(vAlign);
        style.setAlignment(hAlign);
        return style;
    }

}
