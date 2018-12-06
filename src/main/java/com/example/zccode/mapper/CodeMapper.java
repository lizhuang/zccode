package com.example.zccode.mapper;

import com.example.zccode.po.Code;

import java.util.List;

public interface CodeMapper {

    /**
     * 插入数据
     * @param code
     * @return
     */
    public int insert(Code code);


    /**
     * 批量插入数据
     * @param code
     */
    public void batchInsert(List<Code> code);
}
