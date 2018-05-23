package util;

import java.time.LocalDateTime;

/**
 * Handles the creation of logs.
 */
public class LogHandler {

    private StringBuilder exceptionLog = new StringBuilder();

    /**
     * Creates and adds relevant information to a log for Exceptions
     * @param exc The thrown exception.
     */
    public void createExceptionLog(Exception exc) {
        exceptionLog.append("\nTime of exception: ");
        exceptionLog.append(LocalDateTime.now().toString() + "\n");
        exceptionLog.append(exc + "\n");
        exceptionLog.toString();
        }

    /**
     *
     * @return The exception log.
     */
    public String getLog() {
            return exceptionLog.toString();
        }
    }
