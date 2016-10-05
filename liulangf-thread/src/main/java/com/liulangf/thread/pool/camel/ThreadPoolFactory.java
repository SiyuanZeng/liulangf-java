package com.liulangf.thread.pool.camel;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/**
 * Creates ExecutorService and ScheduledExecutorService objects that work with a thread pool for a given ThreadPoolProfile and ThreadFactory.
 * 
 * This interface allows to customize the creation of these objects to adapt camel for application servers and other environments where thread pools
 * should not be created with the jdk methods
 */
public interface ThreadPoolFactory {

    /**
     * Creates a new cached thread pool
     * <p/>
     * The cached thread pool is a term from the JDK from the method {@link java.util.concurrent.Executors#newCachedThreadPool()}.
     * Typically it will have no size limit (this is why it is handled separately
     *
     * @param threadFactory factory for creating threads
     * @return the created thread pool
     */
    ExecutorService newCachedThreadPool(ThreadFactory threadFactory);
    
    /**
     * Create a thread pool using the given thread pool profile
     * 
     * @param profile parameters of the thread pool
     * @param threadFactory factory for creating threads
     * @return the created thread pool
     */
    ExecutorService newThreadPool(ThreadPoolProfile profile, ThreadFactory threadFactory);
    
    /**
     * Create a scheduled thread pool using the given thread pool profile
     * @param profile parameters of the thread pool
     * @param threadFactory factory for creating threads
     * @return the created thread pool
     */
    ScheduledExecutorService newScheduledThreadPool(ThreadPoolProfile profile, ThreadFactory threadFactory);
}