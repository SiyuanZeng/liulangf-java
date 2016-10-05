package com.liulangf.thread.pool.camel;


import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Represent the kinds of options for rejection handlers for thread pools.
 * <p/>
 * These options are used for fine grained thread pool settings, where you
 * want to control which handler to use when a thread pool cannot execute
 * a new task.
 * <p/>
 * Camel will by default use <tt>CallerRuns</tt>.
 */
@XmlType
@XmlEnum(String.class)
public enum ThreadPoolRejectedPolicy {

    Abort, CallerRuns, DiscardOldest, Discard;

    public RejectedExecutionHandler asRejectedExecutionHandler() {
        if (this == Abort) {
            return new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    if (r instanceof Rejectable) {
                        ((Rejectable) r).reject();
                    }
                }

                @Override
                public String toString() {
                    return "Abort";
                }
            };
        } else if (this == CallerRuns) {
            return new ThreadPoolExecutor.CallerRunsPolicy() {
                @Override
                public String toString() {
                    return "CallerRuns";
                }
            };
        } else if (this == DiscardOldest) {
            return new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    if (!executor.isShutdown()) {
                        Runnable rejected = executor.getQueue().poll();
                        if (rejected instanceof Rejectable) {
                            ((Rejectable) rejected).reject();
                        }
                        executor.execute(r);
                    }
                }

                @Override
                public String toString() {
                    return "DiscardOldest";
                }
            };
        } else if (this == Discard) {
            return new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    if (r instanceof Rejectable) {
                        ((Rejectable) r).reject();
                    }
                }

                @Override
                public String toString() {
                    return "Discard";
                }
            };
        }
        throw new IllegalArgumentException("Unknown ThreadPoolRejectedPolicy: " + this);
    }

}
