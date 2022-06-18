package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateTimeUtil {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    public static LocalDateTime parseDateTime(String target) {
        LocalDateTime dateTime = null;
        try {
            dateTime = LocalDateTime.parse(target, formatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }

        return dateTime;
    }
}
