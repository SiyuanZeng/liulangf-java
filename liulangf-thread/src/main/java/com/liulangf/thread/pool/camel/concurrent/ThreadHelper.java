package com.liulangf.thread.pool.camel.concurrent;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Various helper method for thread naming.
 */
public final class ThreadHelper {
    public static final String DEFAULT_PATTERN = "Camel Thread ##counter# - #name#";
    private static final Pattern INVALID_PATTERN = Pattern.compile(".*#\\w+#.*");

    private static AtomicLong threadCounter = new AtomicLong();
    
    private ThreadHelper() {
    }
    
    private static long nextThreadCounter() {
        return threadCounter.getAndIncrement();
    }

    /**
     * Creates a new thread name with the given pattern
     * <p/>
     * See {@link org.apache.camel.spi.ExecutorServiceManager#setThreadNamePattern(String)} for supported patterns.
     *
     * @param pattern the pattern
     * @param name    the name
     * @return the thread name, which is unique
     */
    public static String resolveThreadName(String pattern, String name) {
        if (pattern == null) {
            pattern = DEFAULT_PATTERN;
        }

        // we support #longName# and #name# as name placeholders
        String longName = name;
        String shortName = name.contains("?") ? "" : name;
        // must quote the names to have it work as literal replacement
        shortName = Matcher.quoteReplacement(shortName);
        longName = Matcher.quoteReplacement(longName);

        // replace tokens
        String answer = pattern.replaceFirst("#counter#", "" + nextThreadCounter());
        answer = answer.replaceFirst("#longName#", longName);
        answer = answer.replaceFirst("#name#", shortName);

        // are there any #word# combos left, if so they should be considered invalid tokens
        if (INVALID_PATTERN.matcher(answer).matches()) {
            throw new IllegalArgumentException("Pattern is invalid: " + pattern);
        }

        return answer;
    }

}
