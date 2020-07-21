package com.shanezhou.springboot.generate;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 二维码生成工具
 * @Author ZhouWX
 * @CreateDate 2020/7/20 星期一
 */
public class QRCodeGenerator {

    private static final int QRCOLOR = 0xFF000000;  // 前景色 黑色
    private static final int BGCOLOR = 0xFFFFFFFF;  // 背景颜色 白色

    private static int width = 100;
    private static int height = 100;

    // 设置QR二维码参数
    private static Map<EncodeHintType, Object> hints = new HashMap<>(){
        {
            // 设置QR二维码的纠错等级（H为最高级别） 具体级别信息
            put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            // 设置编码方式
            put(EncodeHintType.CHARACTER_SET, "UTF-8");
            // 边的宽度
            put(EncodeHintType.MARGIN, 0);
        }
    };

    /**
     * 创建一个二维码
     * @param logoFile  logo文件
     * @param QRUrl 地址
     * @param content   内容
     * @return
     */
    public static BufferedImage drawQRCode(File logoFile, String QRUrl, String content) {
        MultiFormatWriter writer = new MultiFormatWriter();
        try {
            // 创建比特矩阵(位矩阵)的QR码编码的字符串
            BitMatrix bm = writer.encode(QRUrl, BarcodeFormat.QR_CODE,
                    width, height, hints);
            // 画出二维码
            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);

            // 利用二维码数据 创建 bitmap 图片，分别设置为 黑 白 两色
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    image.setRGB(i, j, bm.get(i, j) ? QRCOLOR : BGCOLOR);
                }
            }

            if (Objects.nonNull(logoFile) && logoFile.exists()) {
                // 构建绘图对象
                Graphics2D g = image.createGraphics();
                // 读取logo图片
                BufferedImage logo = ImageIO.read(logoFile);
                // 绘制logo图片
                g.drawImage(logo, width * 2 / 5, height * 2 / 5, width * 2 / 10,
                        height * 2 / 10, null);
                g.dispose();
                logo.flush();
            }

            // 二维码下自定义文本描述
            //if (StringUtils.isNotEmpty(content)) {
            //    // 新的图片，把带logo的二维码下面带上文字
            //    BufferedImage outImage = new BufferedImage(width, height + 10,
            //            BufferedImage.TYPE_4BYTE_ABGR);
            //    Graphics2D outG = outImage.createGraphics();
            //    // 画二维码到新的画板
            //    outG.drawImage(image, 0, 0, image.getWidth(),
            //            image.getHeight(), null);
            //    // 画文字到新的画板
            //    // 设置颜色
            //    outG.setColor(Color.red);
            //    // 设置字体
            //    outG.setFont(new Font("楷体", Font.BOLD, 20));
            //    int strWidth = outG.getFontMetrics().stringWidth(content);
            //    // 如果字数太多 则截取一部分
            //    if (strWidth > 399) {
            //        String content1 = content.substring(0, content.length() / 2);
            //        String content2 = content.substring(content.length() / 2);
            //        int strWidth1 = outG.getFontMetrics().stringWidth(content1);
            //        int strWidth2 = outG.getFontMetrics().stringWidth(content2);
            //        outG.drawString(content, 200 - strWidth1 / 2,
            //                height + (outImage.getHeight() - height) / 2 + 12);
            //
            //        BufferedImage outImage2 = new BufferedImage(400, 485,
            //                BufferedImage.TYPE_4BYTE_ABGR);
            //        Graphics2D outG2 = outImage2.createGraphics();
            //        outG2.drawImage(outImage, 0, 0, outImage.getWidth(),
            //                outImage.getHeight(), null);
            //        outG2.setColor(Color.black);
            //        outG2.setFont(new Font("宋体", Font.BOLD, 20));
            //        outG2.drawString(content2, 200 - strWidth2 / 2,
            //                outImage.getHeight() + (outImage2.getHeight() - outImage.getHeight()) / 2 + 5);
            //        outG2.dispose();
            //        outImage2.flush();
            //        outImage = outImage2;
            //    } else {
            //        outG.drawString(content, 200 - strWidth / 2,
            //                height + (outImage.getHeight() - height) / 2 + 12);
            //    }
            //    outG.dispose();
            //    outImage.flush();
            //    image = outImage;
            //}
            return image;
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 读取二维码中的信息
     * @param is    输入流
     */
    public static void readQRCode(InputStream is) {
        try {
            // 读取流信息
            BufferedImage image = ImageIO.read(is);
            // 将图像转化为二进制位图源
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            QRCodeReader reader = new QRCodeReader();
            Result result = null;
            try {
                result = reader.decode(bitmap);
                System.out.println(result.getText());
            } catch (NotFoundException e) {
                e.printStackTrace();
            } catch (ChecksumException e) {
                e.printStackTrace();
            } catch (FormatException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
