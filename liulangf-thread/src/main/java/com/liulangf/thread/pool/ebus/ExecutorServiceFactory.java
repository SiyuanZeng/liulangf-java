package com.liulangf.thread.pool.ebus;

import java.util.concurrent.ExecutorService;

/**
 *
 */
public interface ExecutorServiceFactory {

    /**
     * @return
     */
    ExecutorService newThreadPool();

}
