package com.bymoz.logreader.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Common utilities that used in logreader project
 *
 * @author Huda Waskito
 * @since 17 Mar 2023
 */
@Component
public class CommonUtils {

	@Value("${logreader.dateFormat}")
	private String LOGREADER_DATE_FORMAT;
	
    /**
	 * Check whether the given {@code String} is empty.
	 * <p>This method accepts any {@code String} as an argument. Trim it, and then
     * comparing it to {@code null} and the empty {@code String}.
 	 * - based on org.springframework.util.StringUtils
	 * @param str the {@code String}
	 * @since 3.2.1
	 */
	public boolean isEmpty(String str) {
		if (str == null) return true;

        str = str.trim();
		return (str == null || "".equals(str));
    }
    
    public Integer convertToInteger(String number) {
        return isEmpty(number) ? null : Integer.parseInt(number.trim());
    }

    public LocalDateTime convertToLocalDate(String date) {
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern(LOGREADER_DATE_FORMAT).toFormatter();
					
        return isEmpty(date) ? null: LocalDateTime.parse(date, formatter);
    }

}