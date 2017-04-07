package hu.david.veres.graph.util;

import org.apache.commons.lang.RandomStringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ProcessUtils {

    private static final String DATE_AND_TIME_FORMAT = "yyyyMMddHHmmssSSSS";
    private static final String PACKAGE = "pkg";

    private ProcessUtils() {
    }

    public static String generateProcessIdentifier() {

        String timeStamp = DateTimeFormatter.ofPattern(DATE_AND_TIME_FORMAT).format(LocalDateTime.now());
        String randomString = RandomStringUtils.randomAlphanumeric(20);

        return timeStamp + "_" + randomString;

    }

    public static String generateStateSpaceFileName() {

        String timeStamp = DateTimeFormatter.ofPattern(DATE_AND_TIME_FORMAT).format(LocalDateTime.now());
        String randomString = RandomStringUtils.randomAlphanumeric(20);

        return timeStamp + "_" + randomString;

    }

    public static String generatePackageName() {

        String randomString1 = RandomStringUtils.randomAlphabetic(20);
        String randomString2 = RandomStringUtils.randomAlphabetic(20);

        return PACKAGE + "." + randomString1 + "." + randomString2;

    }

}
