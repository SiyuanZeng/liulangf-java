package com.liulangf.thread.pattern.specific;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-13
 */
public class Logger {
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<TSLog>();

    // 加入一个log
    public static void println(String s) {
        getTSLog().println(s);
    }

    // 关闭log
    public static void close() {
        getTSLog().close();
    }

    // 取得线程特有的log
    private static TSLog getTSLog() {
        TSLog tsLog = (TSLog)tsLogCollection.get();

        //如果线程是第一次呼叫，就建立新挡案并登陆log
        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }

        return tsLog;
    }
    
    private static class ActionContextThreadLocal extends ThreadLocal<TSLog> {
        protected TSLog initialValue() {
        	TSLog log = new TSLog(Thread.currentThread().getName() + "-log.txt");
            return log;
        }
    }
}
