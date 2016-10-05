/**
* 版权所有:(C)2001-2012 北京中油瑞飞信息技术有限责任公司
* Author : 刘余庆
* Creation time : 2012-10-30 下午4:35:26
* Description :
*/
package com.liulangf.thread.pool.java2s.chapter3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class SingleThreadAccess {
    private ThreadPoolExecutor tpe;

    public SingleThreadAccess() {
          tpe = new ThreadPoolExecutor(
            1, 1, 50000L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>());
      }  
    
    public void invokeLater(Runnable r) {
      tpe.execute(r);
    }

    public void invokeAneWait(Runnable r) throws InterruptedException,
        ExecutionException {
      FutureTask<?> task = new FutureTask(r, null);
      tpe.execute(task);
      task.get();
    }

    public void shutdown() {
      tpe.shutdown();
    }
}
