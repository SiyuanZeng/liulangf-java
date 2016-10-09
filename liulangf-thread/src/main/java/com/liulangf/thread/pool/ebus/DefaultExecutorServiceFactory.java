package com.liulangf.thread.pool.ebus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

/**
 * 默认的线程池工厂类
 */
public class DefaultExecutorServiceFactory implements ExecutorServiceFactory {

    @Inject
    private ThreadFactory threadFactory;
    
    @Inject
    private int size;
    
    @Override
    public ExecutorService newThreadPool() {
        return new ThreadPoolExecutor(0, size,
                5L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(),
                threadFactory);
    }
    
}
