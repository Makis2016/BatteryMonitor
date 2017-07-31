package com.furongsoft.XspWeb.Common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 定义日志记录器类型
 *
 * @author Alex
 */
public class Tracker
{
    private static Logger sLogger = LoggerFactory.getLogger(Tracker.class);
    private static Logger sNetworkLogger = LoggerFactory.getLogger("network");

    public static void d(final String content)
    {
        sLogger.debug(makeLog(content));
    }

    public static void i(final String content)
    {
        sLogger.info(makeLog(content));
    }

    public static void w(final String content)
    {
        sLogger.warn(makeLog(content));
    }

    public static void e(final String content)
    {
        sLogger.error(makeLog(content));
    }

    public static void e(final Exception e)
    {
        sLogger.error(makeLog(getStackTrace(e)));
    }

    public static void e(final String content, final Exception e)
    {
        sLogger.error(makeLog(content + ": " + e.toString()));
    }

    public static void network(final String content)
    {
        sNetworkLogger.info(makeLog(content));
    }

    private static String makeLog(final String content)
    {
        StackTraceElement elem = new Throwable().getStackTrace()[2];

        return elem.getFileName() + "(" + elem.getLineNumber() + "): " + content;
    }

    private static String getStackTrace(final Throwable throwable)
    {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);

        return sw.getBuffer().toString();
    }
}