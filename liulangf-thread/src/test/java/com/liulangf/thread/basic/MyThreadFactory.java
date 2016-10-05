/**
* 版权所有:(C)2001-2012 北京中油瑞飞信息技术有限责任公司
* Author : 刘余庆
* Creation time : 2012-11-5 下午1:57:44
* Description :
*/
package com.liulangf.thread.basic;

import java.util.HashSet;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class MyThreadFactory implements ThreadFactory {
    private int largestPoolSize = 10;
    private final ReentrantLock mainLock = new ReentrantLock();
    private HashSet<MyThread> workers = new HashSet<MyThread>();

    public Thread newThread(Runnable task) {
        MyThread t = null;
        try {
            t = getThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.setTask(task);
        return t;
    }
    
    public synchronized MyThread getThread() throws InterruptedException {
        if (workers.isEmpty()) {
            MyThread t = new MyThread();
            workers.add(t);
            return t;
        }
        for (MyThread t : workers) {
            if (t.getTask() == null) {
//                notifyAll();
                return t;
            }
        }
        
        int s = workers.size();
        if (s == largestPoolSize) {
//            wait();
        }
        
        MyThread result = new MyThread();
        workers.add(result);
//        notifyAll();
        return result;
    }
}
