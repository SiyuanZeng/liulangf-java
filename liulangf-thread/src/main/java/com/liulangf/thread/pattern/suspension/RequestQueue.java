package com.liulangf.thread.pattern.suspension;

import java.util.LinkedList;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-7
 */
public class RequestQueue {
    private final LinkedList<Request> queue = new LinkedList<Request>();
    
    public synchronized Request getRequest() throws InterruptedException {
        while (queue.size() <= 0) {
        	wait();
        }                                           
        return queue.removeFirst();
    }
    
    public synchronized void putRequest(Request request) {
        queue.addLast(request);
        notifyAll();
    }
}
