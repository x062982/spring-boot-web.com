package com.shanezhou.springboot.test;

import lombok.NonNull;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author ZhouWX
 * @CreateDate 2020/7/27 星期一
 */
public class WordToPinyinTest {

    public static void main(String[] args) {

        String s = "1adA31啊的玩法";
        s = " 1 dw我的 ".trim();
        //s += first(s);
        s = getPinyin(s);
        String[] s1 = s.split("_");
        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i]);
        }
        System.out.println(s);
    }

    public static String getPinyin(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        String[] array = new String[chars.length];
        try {
            HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
            format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
            for (char c : chars) {
                if (c >= 97 && c <= 123) {
                    stringBuilder.append((char)(c ^ 32) + "_");
                } else if (Character.toString(c).matches("[\\u4E00-\\u9FA5]+")) {
                    array = PinyinHelper.toHanyuPinyinStringArray(c, format);
                    stringBuilder.append(array[0] + "_");
                } else if (c != 32) {
                    stringBuilder.append(c + "_");
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }
        return stringBuilder.substring(0, stringBuilder.lastIndexOf("_"));
    }

    public static String first(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        char ch = str.charAt(0);
        if (ch >= 97 && ch <= 123) {
            return String.valueOf((char)(ch - 32));
        }
        if (ch >= 65 && ch <= 91) {
            return String.valueOf(ch);
        }
        try {
            HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
            format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
            format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            if (Character.toString(ch).matches("[\\u4E00-\\u9FA5]+")) {
                String[] strArr = PinyinHelper.toHanyuPinyinStringArray(ch, format);
                if (strArr != null) {
                    return String.valueOf(strArr[0].charAt(0));
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }
        return String.valueOf(ch);
    }
}
