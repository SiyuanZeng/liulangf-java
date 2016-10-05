package com.liulangf.thread.pattern.active;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-13
 */
class FutureResult extends Result {
    private Result result;
    private boolean ready = false;
    public synchronized void setResult(Result result) {
        this.result = result;
        this.ready = true;
        notifyAll();
    }
    public synchronized Object getResultValue() {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        return result.getResultValue();
    }
}
