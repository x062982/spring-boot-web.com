package com.shanezhou.springboot.util.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author ZhouWX
 * @CreateDate 2020/8/20 星期四
 */
public class TestPDF {

    private int maxWidth = 520;
    private int height = 32;
    private static Font titleFont;
    private static Font textFont;
    private static int fontSize = 12;
    Document document = new Document();
    static BaseFont baseFont;

    PdfContentByte canvas;

    static {
        try {
            baseFont = BaseFont.createFont("font/STSONG.TTF",
                        BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            titleFont = new Font(baseFont, 16, Font.BOLD);
            textFont = new Font(baseFont, fontSize);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TestPDF(File file) {
        document.setPageSize(PageSize.A4);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            canvas = writer.getDirectContent();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PdfPCell createCellColspan(String value,int colspan) {
        PdfPCell cell = createCell(value);
        cell.setColspan(colspan);
        return cell;
    }

    public PdfPCell createCellRowspan(String value, int rowspan) {
        PdfPCell cell = createCell(value);
        cell.setRowspan(rowspan);
        return cell;
    }


    public PdfPCell createCell(String value,  Font font, int align, int colspan, int rowspan) {
        PdfPCell cell = createCell(value,font);
        cell.setHorizontalAlignment(align);
        cell.setColspan(colspan);
        cell.setRowspan(rowspan);
        return cell;
    }
    /**
     * 创建表格
     * @param value
     * @param align
     * @param font
     * @return
     */
    public PdfPCell createCell(String value, Font font, int height, int align, int colspan, int rowspan) {
        PdfPCell cell = new PdfPCell();
        cell.setColspan(colspan);
        cell.setRowspan(rowspan);
        cell.setFixedHeight(height);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setPhrase(new Phrase(value, font));

        cell.setBorderColor(new BaseColor(0, 0, 0));
        cell.setBackgroundColor(new BaseColor(255));

        return cell;
    }

    public PdfPCell createCell(String value, Font font) {
        PdfPCell cell = new PdfPCell();
        cell.setFixedHeight(height);

        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPhrase(new Phrase(value, font));

        cell.setBorderColor(new BaseColor(0, 0, 0));
        cell.setBackgroundColor(new BaseColor(255));

        return cell;
    }

    public PdfPCell createCell(String value) {
        PdfPCell cell = new PdfPCell();
        cell.setFixedHeight(height);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPhrase(new Phrase(value, textFont));
        cell.setBorderColor(new BaseColor(0, 0, 0));
        cell.setBackgroundColor(new BaseColor(255));

        return cell;
    }

    public PdfPCell createCell(String value, int colspan, int rowspan) {
        PdfPCell cell = createCell(value,textFont);
        cell.setColspan(colspan);
        cell.setRowspan(rowspan);
        return cell;
    }

    public PdfPTable createTable(int colNumber) {
        PdfPTable table = new PdfPTable(colNumber);
        table.setTotalWidth(maxWidth);
        table.setLockedWidth(true);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setBorder(1);
        return table;
    }

    public PdfPTable createTable(float[] widths) {
        PdfPTable table = new PdfPTable(widths);
        table.setTotalWidth(500);
        table.setLockedWidth(true);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setBorder(1);
        return table;
    }

    public PdfPTable createBlankTable() {
        PdfPTable table = new PdfPTable(1);
        table.getDefaultCell().setBorder(0);
        table.addCell(createCell(""));
        table.setSpacingAfter(20f);
        table.setSpacingBefore(20f);
        return table;
    }

    public PdfPCell createCellRowspan(String value, Font font, int rowspan) {
        PdfPCell cell = new PdfPCell();

        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPhrase(new Phrase(value, font));
        cell.setRowspan(rowspan);

        return cell;
    }

    public PdfPCell addImage(Image image, int width, int height) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        //cell.setFixedHeight(width);
        //cell.setFixedHeight(height);
        cell.addElement(image);

        image.setScaleToFitHeight(true);

        cell.setBorderColor(new BaseColor(0, 0, 0));
        cell.setBackgroundColor(new BaseColor(255));

        return cell;
    }

    public PdfPCell addImage(Image image, int width, int height, int colspan, int rowspan) {
        PdfPCell cell = addImage(image, width, height);
        cell.setRowspan(rowspan);
        cell.setColspan(colspan);
        return cell;
    }

    public void generateFinishPDF() throws DocumentException {
        PdfPTable table = createTable(6);
        Image image = null;
        try {
            image = Image.getInstance("src\\main\\resources\\image\\logo.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 头
        table.addCell(addImage(image, 70, 70, 1, 2));
        table.addCell(createCell("四特酒有限责任公司检测中心 ",
                titleFont, height, Element.ALIGN_CENTER,4, 1));
        table.addCell(createCell("STJC-JJ-21-1", textFont, height,
                Element.ALIGN_CENTER, 1, 1));
        table.addCell(createCell("品   评  报  告",titleFont, height,
                Element.ALIGN_CENTER, 5, 1));

        table.addCell(createCell("地址：中国江西省宜春市樟树市药都北大道11号，邮编：331200",
                textFont, height, Element.ALIGN_LEFT, 4, 1));
        table.addCell(createCell("出证日期:"));
        table.addCell(createCell(""));

        table.addCell(createCell("电话：（Tel）:0086-795-7361907   传真（Fax）:0086-795-7361576",
                textFont, height, Element.ALIGN_LEFT,6, 1));
        // 详细信息
        table.addCell(createCell("样品名称"));
        table.addCell(createCell(""));
        table.addCell(createCell("规格型号", 2, 1));
        table.addCell(createCell("/", 2, 1));
        table.addCell(createCell("样品编号"));
        table.addCell(createCell(""));
        table.addCell(createCell("样品包装/状态"));
        table.addCell(createCell(""));
        table.addCell(createCell("样品来源"));
        table.addCell(createCell(""));
        table.addCell(createCell("生产日期（批号）"));
        table.addCell(createCell(""));
        table.addCell(createCell("检测依据"));
        table.addCell(createCell("", 3, 1));
        table.addCell(createCell("总产量"));
        table.addCell(createCell("/"));
        table.addCell(createCell("内检员"));
        table.addCell(createCell("/"));
        table.addCell(createCell("生产线号"));
        table.addCell(createCell("/"));
        table.addCell(createCell("送样人"));
        table.addCell(createCell(""));
        table.addCell(createCell("收样人"));
        table.addCell(createCell(""));
        table.addCell(createCell("样品数量"));
        table.addCell(createCell(""));
        table.addCell(createCell("送样日期"));
        table.addCell(createCell(""));
        table.addCell(createCell("收样日期"));
        table.addCell(createCell(""));
        table.addCell(createCell("检验日期"));
        table.addCell(createCell(""));
        table.addCell(createCell("判定标准"));
        table.addCell(createCell("", 5, 1));
        table.addCell(createCell("检测项目", 2, 1));
        table.addCell(createCell("技术要求", 2, 1));
        table.addCell(createCell("检测结果"));
        table.addCell(createCell("单项判定"));
        table.addCell(createCell("感官检验", 1, 4));
        table.addCell(createCell("色泽"));
        table.addCell(createCell("清亮透明、无悬浮物、无沉淀",  textFont,
                Element.ALIGN_LEFT, 2, 1));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell("香气"));
        table.addCell(createCell("香气幽雅舒适、浓、清、酱兼而有之、诸香协调",  textFont,
                Element.ALIGN_LEFT, 2, 1));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell("口味"));
        table.addCell(createCell("入口绵甜、酒体丰润、后味绵长净爽",  textFont,
                Element.ALIGN_LEFT, 2, 1));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell("风格"));
        table.addCell(createCell("具有本品风格", textFont,
                Element.ALIGN_LEFT, 2, 1));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell("",  textFont, 100,
                Element.ALIGN_CENTER, 6, 1));
        table.addCell(createCell("检验结论", 2, 1));
        table.addCell(createCell("",4, 1));
        table.addCell(createCell("编制：", textFont,
                Element.ALIGN_LEFT, 2, 1));
        table.addCell(createCell("审核：", textFont,
                Element.ALIGN_LEFT, 2, 1));
        table.addCell(createCell("批准：", textFont,
                Element.ALIGN_LEFT, 2, 1));

        document.add(table);
        document.close();
    }

    public void drawLine(PdfContentByte canvas, float left, float top, int x, int y) {
        canvas.saveState();
        canvas.moveTo(left,top);
        canvas.lineTo(left + x, top - y);
        canvas.stroke();
        canvas.restoreState();
    }

    public void generateBasicPDF() throws DocumentException {
        PdfPTable table = createTable(6);
        float[] widths = {0.15f, 0.17f, 0.17f, 0.17f, 0.17f, 0.17f};
        table.setWidths(widths);
        Image image = null;
        try {
            image = Image.getInstance("src\\main\\resources\\image\\logo.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        table.addCell(addImage(image, 70, 70, 1, 2));
        table.addCell(createCell("四特酒有限责任公司检测中心 ",
                titleFont, height, Element.ALIGN_CENTER,4, 1));
        table.addCell(createCell("STJC-JJ-21-1", textFont, height,
                Element.ALIGN_CENTER, 1, 1));
        table.addCell(createCell("检   验  报  告   单",titleFont, height,
                Element.ALIGN_CENTER, 5, 1));
        table.addCell(createCell("来样日期："));
        table.addCell(createCell(""));
        table.addCell(createCell("送样日期："));
        table.addCell(createCell(""));
        table.addCell(createCell("检验日期"));
        table.addCell(createCell(""));
        table.addCell(createCell("送样人"));
        table.addCell(createCell("", 3, 1));
        table.addCell(createCell("样品来源"));
        table.addCell(createCell(""));
        PdfPCell cell1 = createCell("项目          数据", new Font(baseFont, 10),
                Element.ALIGN_CENTER, 1, 2);
        float left = document.leftMargin() + cell1.getColumn().getRunDirection();
        float top = document.getPageSize().getHeight();
        table.addCell(cell1);

        drawLine(canvas, left,
                top - (table.getRowHeight(1) + table.getRowHeight(2)
                        + table.getRowHeight(3) + document.topMargin() + height),
                (int)(widths[0]), (int)(height * 2));
        table.addCell(createCell("技术要求", 1, 2));
        table.addCell(createCell("样品名称", 4, 1));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell("≥68"));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell("色"));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell("香"));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell("味"));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell("风格"));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell("总分"));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        table.addCell(createCell(""));
        PdfPCell cell = createCell("检验结论：", textFont,
                Element.ALIGN_LEFT, 6, 1);
        cell.setFixedHeight(100);
        cell.setVerticalAlignment(Element.ALIGN_TOP);
        table.addCell(cell);
        table.addCell(createCell("检验："));
        table.addCell(createCell(""));
        table.addCell(createCell("审核："));
        table.addCell(createCell(""));
        table.addCell(createCell("批准："));
        table.addCell(createCell(""));

        document.add(table);
        document.close();
    }

    public void testItext(File file) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter pdfWriter = PdfWriter.getInstance(document,
                new FileOutputStream(file));
        BaseFont font = BaseFont.createFont("font/STSONG.TTF",
                BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Paragraph elements = new Paragraph("测试生成pdf文件！hello", new Font(font));
        document.open();
        document.add(elements);
        document.close();
    }

    public static void main(String[] args) throws IOException, DocumentException {
        String fileName = "testBasic.pdf";
        File file = new File(fileName);
        new TestPDF(file).generateBasicPDF();
        System.out.println("生成成功");
    }
}
