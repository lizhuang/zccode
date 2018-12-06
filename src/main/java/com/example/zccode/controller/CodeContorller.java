package com.example.zccode.controller;

import com.example.zccode.dao.CodeDao;
import com.example.zccode.po.Code;
import com.example.zccode.service.XMLReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CodeContorller {

    @Autowired
    private CodeDao codeDao;

    @Autowired
    private XMLReaderService service;

    @RequestMapping("/save")
    public String save() {

        Code code = new Code();
        code.setCode("code");
        code.setProduceTime(new Date());
        code.setProductLine("pl");
        code.setType(1);
        code.setPackCode("222");

        int row = codeDao.insertCode(code);
        //判断结果
        return String.valueOf(row);
    }

    @RequestMapping("/read")
    public String read(){
        service.temp();
        return "read";
    }

}
