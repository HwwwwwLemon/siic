package com.hwwwww.siic.config.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/11 21:57
 */
@Component
public class DateToStringConverter implements Converter<Date, String> {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String SHORT_DATE_FORMAT = "yyyy-MM-dd";

    @Override
    public String convert(Date source) {

        try {
            SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
            System.out.println(format.format(source));
            return format.format(source);
        } catch (Exception e) {
            SimpleDateFormat format = new SimpleDateFormat(SHORT_DATE_FORMAT);
            System.out.println(format.format(source));
            return format.format(source);
        }
    }
}
