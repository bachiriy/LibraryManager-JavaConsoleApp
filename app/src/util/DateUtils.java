package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils { 
	public static boolean isValiDate(String dateStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inputDate = LocalDate.parse(dateStr, formatter);
            LocalDate now = LocalDate.now();

            return !inputDate.isAfter(now);

        } catch (DateTimeParseException e) {
            return false;
        }
    }
    public static String toHumanDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy");
        String formattedDate = date.format(formatter);
        return formattedDate;
    }

}
