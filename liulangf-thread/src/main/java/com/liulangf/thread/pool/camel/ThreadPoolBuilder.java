package com.liulangf.thread.pool.camel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * A builder to create thread pools.
 *
 * @version 
 */
public final class ThreadPoolBuilder {

    // reuse a profile to store the settings
    private final ThreadPoolProfile profile;
    
    private final ExecutorServiceManager manager;

    public ThreadPoolBuilder(ExecutorServiceManager manager) {
        this.manager = manager;
        this.profile = new ThreadPoolProfile();
    }
    
    public ThreadPoolBuilder poolSize(int poolSize) {
        profile.setPoolSize(poolSize);
        return this;
    }

    public ThreadPoolBuilder maxPoolSize(int maxPoolSize) {
        profile.setMaxPoolSize(maxPoolSize);
        return this;
    }
    
    public ThreadPoolBuilder keepAliveTime(long keepAliveTime, TimeUnit timeUnit) {
        profile.setKeepAliveTime(keepAliveTime);
        profile.setTimeUnit(timeUnit);
        return this;
    }

    public ThreadPoolBuilder keepAliveTime(long keepAliveTime) {
        profile.setKeepAliveTime(keepAliveTime);
        return this;
    }

    public ThreadPoolBuilder maxQueueSize(int maxQueueSize) {
        profile.setMaxQueueSize(maxQueueSize);
        return this;
    }

    public ThreadPoolBuilder rejectedPolicy(ThreadPoolRejectedPolicy rejectedPolicy) {
        profile.setRejectedPolicy(rejectedPolicy);
        return this;
    }
    
    /**
     * Builds the new thread pool
     *
     * @return the created thread pool
     * @throws Exception is thrown if error building the thread pool
     */
    public ExecutorService build() throws Exception {
        return build(null, null);
    }

    /**
     * Builds the new thread pool
     *
     * @param name name which is appended to the thread name
     * @return the created thread pool
     * @throws Exception is thrown if error building the thread pool
     */
    public ExecutorService build(String name) throws Exception {
        return build(null, name);
    }

    /**
     * Builds the new thread pool
     *
     * @param source the source object, usually it should be <tt>this</tt> passed in as parameter
     * @param name   name which is appended to the thread name
     * @return the created thread pool
     * @throws Exception is thrown if error building the thread pool
     */
    public ExecutorService build(Object source, String name) throws Exception {
        return manager.newThreadPool(source, name, profile);
    }

    /**
     * Builds the new scheduled thread pool
     *
     * @return the created scheduled thread pool
     * @throws Exception is thrown if error building the scheduled thread pool
     */
    public ScheduledExecutorService buildScheduled() throws Exception {
        return buildScheduled(null, null);
    }

    /**
     * Builds the new scheduled thread pool
     *
     * @param name name which is appended to the thread name
     * @return the created scheduled thread pool
     * @throws Exception is thrown if error building the scheduled thread pool
     */
    public ScheduledExecutorService buildScheduled(String name) throws Exception {
        return buildScheduled(null, name);
    }

    /**
     * Builds the new scheduled thread pool
     *
     * @param source the source object, usually it should be <tt>this</tt> passed in as parameter
     * @param name   name which is appended to the thread name
     * @return the created scheduled thread pool
     * @throws Exception is thrown if error building the scheduled thread pool
     */
    public ScheduledExecutorService buildScheduled(Object source, String name) throws Exception {
        return manager.newScheduledThreadPool(source, name, profile);
    }

}
