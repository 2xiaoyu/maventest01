package com.smbms.dateconverter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH-mm");
        if (s == null || "".equals(s.trim())) {
            return null;
        }
        Date date = null;
        try {
            if (s.length() == 10) {
                date = sdf.parse(s);
            } else if (s.length() == 19) {
                date = sdf2.parse(s);
            } else if (s.length() == 16) {
                date = sdf3.parse(s);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return date;
    }
}
