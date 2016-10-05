package com.liulangf.thread.pattern.active;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-13
 */
class SchedulerThread extends Thread {
    private final ActivationQueue queue;
    public SchedulerThread(ActivationQueue queue) {
        this.queue = queue;
    }
    public void invoke(MethodRequest request) {
        queue.putRequest(request);
    }
    public void run() {
        while (true) {
            MethodRequest request = queue.takeRequest();
            request.execute();
        }
    }
}
