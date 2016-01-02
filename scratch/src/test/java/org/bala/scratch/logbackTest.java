package org.bala.scratch;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by murali on 11/05/14.
 */
public class logbackTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(logbackTest.class);

    public static void printLoggerState() {
        LOGGER.info("<*** Begin PrintingLoggerState! ***>");
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
        LOGGER.info("<*** End PrintingLoggerState! ***>");
    }

    @Test
    public void myTest1() {
        printLoggerState();
        LOGGER.info("Hello, World!");
    }
}
