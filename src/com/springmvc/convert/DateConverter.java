package com.springmvc.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author GOU
 * @Date 2020-04-26 20:16
 */
public class DateConverter implements Converter<String,Date> {

    //定义日期格式
    private String datePattern = "yyyy-mm-dd HH:mm:ss";

    @Override
    public Date convert(String source) {
        //格式化日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);

        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            try {
                throw new IllegalAccessException("无效的日期格式，请使用这种格式："+datePattern);
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
        }
    return null;
    }

}
