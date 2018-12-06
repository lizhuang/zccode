package com.example.zccode.dao;

import com.example.zccode.po.Code;

import java.util.List;

public interface CodeDao {

    /**
     * 插入新码
     * @return
     */
    public int insertCode(Code code);

    /**
     * 查询单个码
     * @param code
     * @return
     */
    public Code queryCode(String code);

    /**
     * 查询包装码下的产品码
     * @param packCode
     * @return
     */
    public List<Code> queryContainProductCode(String packCode);


}
