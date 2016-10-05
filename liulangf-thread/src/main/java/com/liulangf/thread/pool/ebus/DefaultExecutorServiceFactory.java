/**
* 版权所有:(C)2001-2012 北京中油瑞飞信息技术有限责任公司
* Author : 刘余庆
* Creation time : 2012-11-1 下午12:48:41
* Description :
*/
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
