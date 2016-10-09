package com.liulangf.thread.pool.ebus;

/**
 * 工作者线程工程类
 */
public interface WorkerProvider {
    
    WorkerThread newWorker();

}
