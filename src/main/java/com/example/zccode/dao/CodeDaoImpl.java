package com.example.zccode.dao;

import com.example.zccode.po.Code;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Service("codeDao")
public class CodeDaoImpl implements CodeDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    private static final String COMMA = ",";

    @Override
    public int insertCode(Code c) {
        StringBuilder sb = new StringBuilder();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String productTime = dateFormat.format(c.getProduceTime());

        sb.append(c.getCode()).append(COMMA)
                .append(c.getPackCode()).append(COMMA)
                .append(c.getType()).append(COMMA).append("'")
                .append(c.getProductLine())
                .append("'")
                .append(COMMA)
                .append("'")
                .append(productTime)
                .append("'")
                .append(COMMA)
                .append("NOW())");

       return jdbcTemplate.update("INSERT INTO t_code (`code`, `pack_code`, `type`, `produce_line`, `produce_time`, `create_time`) " +
               "VALUES("+sb.toString());
    }

    @Override
    public Code queryCode(String code) {
        return null;
    }

    @Override
    public List<Code> queryContainProductCode(String packCode) {
        return null;
    }
}
