package com.example.zccode.xml;

import com.thoughtworks.xstream.converters.SingleValueConverter;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换工具类
 */
public class DateUtil implements SingleValueConverter {
    /**
     * 时间转换格式
     * @param type
     * @return
     */
    @Override
    public boolean canConvert(Class type) {
        return type.equals(Date.class);
    }

    @Override
    public String toString(Object obj) {
        return DateFormatUtils.format((Date) obj, "yyyy-MM-dd");
    }
    @Override
    public Object fromString(String str) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

}
