package util;

import java.time.LocalDateTime;

public class LogHandler {

    private StringBuilder builder = new StringBuilder();

        public void createLog(Exception exc) {
            builder.append("\nTime of exception: ");
            builder.append(LocalDateTime.now().toString() + "\n");
            builder.append(exc + "\n");
            builder.toString();
        }
        public String printLog() {
            return builder.toString();
        }
    }
