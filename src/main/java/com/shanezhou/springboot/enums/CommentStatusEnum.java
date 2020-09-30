package com.shanezhou.springboot.enums;

/**
 * @author ShaneZhou
 * @since 2020/9/8 周二
 */
public enum CommentStatusEnum {

    UNEVALUATED("未品评", 0),
    EVALUATING("已品评", 1);

    /** 描述 */
    private String desc;
    /** 枚举值 */
    private int value;

    private CommentStatusEnum(String desc, int value) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

