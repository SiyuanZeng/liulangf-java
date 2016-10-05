/**
* 版权所有:(C)2001-2012 北京中油瑞飞信息技术有限责任公司
* Author : 刘余庆
* Creation time : 2012-11-6 下午5:11:25
* Description :
*/
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
