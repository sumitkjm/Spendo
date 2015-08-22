package com.mas.em.common;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

public class JAXBDateAdapter {

    public static Date parseDate(String s) {
        return (Date) DatatypeConverter.parseDate(s).getTime();
    }

    public static String printDate(Date dt) {
        String dateFormat = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        if (dt != null) {
            dateFormat = sdf.format(dt);
        }
        return dateFormat;
    }

}
