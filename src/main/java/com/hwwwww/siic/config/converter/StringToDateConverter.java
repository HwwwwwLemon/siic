package com.hwwwww.siic.config.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/11 22:08
 */
@Component
public class StringToDateConverter implements Converter<String, Date> {
    private static final List<String> FORMARTS = new ArrayList<>(4);

    /**
     * 支持的格式
     * 既然已经使用了转换器，就不使用yyyy/MM等形式了。
     * 全局均使用yyyy-MM形式
     */
    static {
        FORMARTS.add("yyyy-MM");
        FORMARTS.add("yyyy-MM-dd");
        FORMARTS.add("yyyy-MM-dd HH:mm");
        FORMARTS.add("yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public Date convert(String source) {
        String value = source.trim();
        if ("".equals(value)) {
            return null;
        }
        if (source.matches("^\\d{4}-\\d{1,2}$")) {
            return parseDate(source, FORMARTS.get(0));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
            return parseDate(source, FORMARTS.get(1));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
            return parseDate(source, FORMARTS.get(2));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
            return parseDate(source, FORMARTS.get(3));
        } else {
            throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
        }
    }

    /**
     * 格式化日期
     *
     * @param dateStr String 字符型日期
     * @param format  String 格式
     * @return Date 日期
     */
    public Date parseDate(String dateStr, String format) {
        Date date = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            date = dateFormat.parse(dateStr);
        } catch (Exception ignored) {

        }
        return date;
    }

}
