package com.example.zccode.po;

import lombok.Data;

import java.util.Date;

@Data
public class Code {
    /**
     * 自增主键
     */
    private int id;
    /**
     * 码，可能为包码，也可能为产品码
     */
    private String code;
    /**
     * 包码，为包码时不保存
     */
    private String packCode;
    /**
     * 类型1包码，2产品码
     */
    private int type;
    /**
     * 产线号
     */
    private String productLine;
    /**
     * 创建时间
     */
    private Date produceTime;
}
