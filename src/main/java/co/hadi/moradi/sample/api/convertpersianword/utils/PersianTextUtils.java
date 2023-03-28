package co.hadi.moradi.sample.api.convertpersianword.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

public class PersianTextUtils {
    public static final Map<String, String> characters;
    public static final Map<String, String> persianNumberschars;

    static {
        Hashtable<String, String> tmp =
                new Hashtable<String, String>();
        tmp.put("ك", "ک");
        tmp.put("دِ", "د");
        tmp.put("بِ", "ب");
        tmp.put("زِ", "ز");
        tmp.put("ذِ", "ذ");
        tmp.put("شِ", "ش");
        tmp.put("سِ", "س");
        tmp.put("ى", "ی");
        tmp.put("ي", "ی");
        tmp.put("١", "۱");
        tmp.put("٢", "۲");
        tmp.put("٣", "۳");
        tmp.put("٤", "۴");
        tmp.put("٥", "۵");
        tmp.put("٦", "۶");
        tmp.put("٧", "۷");
        tmp.put("٨", "۸");
        tmp.put("٩", "۹");
        tmp.put("٠", "۰");

        characters = Collections.unmodifiableMap(tmp);

        Hashtable<String, String> tmpPersianNumbers =
                new Hashtable<String, String>();

        tmp.put("۱", "1");
        tmp.put("۲", "2");
        tmp.put("۳", "3");
        tmp.put("۴", "4");
        tmp.put("۵", "5");
        tmp.put("۶", "6");
        tmp.put("۷", "7");
        tmp.put("۸", "8");
        tmp.put("۹", "9");
        tmp.put("۰", "0");

        persianNumberschars = Collections.unmodifiableMap(tmpPersianNumbers);

    }


    public static String normalizeString(String word) {
        if (StringUtils.isEmpty(word)) {
            return "";
        }

        for (Map.Entry<String, String> entry : characters.entrySet()) {
            word = word.replace(entry.getKey(), entry.getValue());
        }

        return word;
    }

    public static String normalizePersianChar(String numbers) {
        if (StringUtils.isEmpty(numbers)) {
            return "";
        }

        numbers = normalizeString(numbers);

        for (Map.Entry<String, String> entry : persianNumberschars.entrySet()) {
            numbers = numbers.replace(entry.getKey(), entry.getValue());
        }

        return numbers;
    }


}
