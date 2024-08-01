package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class for logging messages using Log4j.
 * <p>
 * Provides static methods to log messages at different levels: DEBUG, INFO, WARN, ERROR, and FATAL.
 * This class is designed to be a singleton and cannot be instantiated.
 */
public class LogUtil {

    // Logger instance for the LogUtil class
    private static final Logger Log = LogManager.getLogger(LogUtil.class.getName());

    // Private constructor to prevent instantiation
    private LogUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Logs a message at DEBUG level.
     *
     * @param message The message to be logged.
     */
    public static void debug(String message) {
        Log.debug(message);
    }

    /**
     * Logs a message at INFO level.
     *
     * @param message The message to be logged.
     */
    public static void info(String message) {
        Log.info(message);
    }

    /**
     * Logs a message at WARN level.
     *
     * @param message The message to be logged.
     */
    public static void warn(String message) {
        Log.warn(message);
    }

    /**
     * Logs a message at ERROR level.
     *
     * @param message The message to be logged.
     */
    public static void error(String message) {
        Log.error(message);
    }

    /**
     * Logs a message at FATAL level.
     *
     * @param message The message to be logged.
     */
    public static void fatal(String message) {
        Log.fatal(message);
    }
}
