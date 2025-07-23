package server.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerLog {

    public static void log(String message) {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy-hh:mm");
        String currentLogTime = LocalDateTime.now().format(dateTimeFormat);

        System.out.println(String.format("Server at [%s] - %s", currentLogTime, message));
    }

}
