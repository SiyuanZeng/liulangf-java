/**
* 版权所有:(C)2001-2012 北京中油瑞飞信息技术有限责任公司
* Author : 刘余庆
* Creation time : 2012-11-6 下午3:42:47
* Description :
*/
package com.liulangf.thread.pool.ebus;

import java.util.concurrent.ThreadFactory;

import javax.inject.Inject;

/**
 * ThreadFactory 简单实现。
 */
public class SimpleThreadFactory implements ThreadFactory, WorkerProvider {

    @Inject
    private Pool<WorkerThread> pool;
    
    @Override
    public Thread newThread(Runnable r) {
        WorkerThread wt = getWorker();
        wt.setTask(r);
        return wt;
    }
    
    @Override
    public WorkerThread newWorker() {
        WorkerThread wt = new WorkerThread(pool);
        return wt;
    }
    
    private WorkerThread getWorker() {
        try {
            return pool.get();
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

}
