package com.liulangf.thread.pool.ebus;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 *
 */
public class ThreadFactoryTest {

    private ExecutorServiceFactory poolFactory;
    
    @Before
    public void setUp() {
        Injector injector = Guice.createInjector(new AbstractModule() {
            public void configure() {
                bind(ExecutorServiceFactory.class).to(DefaultExecutorServiceFactory.class);
                bind(ThreadFactory.class).to(SimpleThreadFactory.class);
                bind(Pool.class).to(SimplePool.class);
                bind(WorkerProvider.class).to(SimpleThreadFactory.class);
                bind(WorkerThread.class).to(WorkerThread.class);
            }
        });
        poolFactory = injector.getInstance(ExecutorServiceFactory.class);
    }
    
    
    
    @Test
    public void test() {
        ExecutorService executor = poolFactory.newThreadPool();
        executor.execute(new Runnable() {
           public void run() {
               String name = Thread.currentThread().getName();
               System.out.println(name + " -> " + new Date());
           }
        });
        
    }

}
