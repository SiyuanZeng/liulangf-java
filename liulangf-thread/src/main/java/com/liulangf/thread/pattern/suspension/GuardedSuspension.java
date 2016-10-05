package com.liulangf.thread.pattern.suspension;

import java.util.concurrent.TimeUnit;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-7
 */
public class GuardedSuspension {
    public static void main(String[] args) throws Exception {
        RequestQueue requestQueue = new RequestQueue();
        Client alice = new Client(requestQueue, "Alice", 3141592L);
        Server bobby = new Server(requestQueue, "Bobby", 6535897L);
        alice.start();
        bobby.start();
        
        TimeUnit.SECONDS.sleep(10);
        alice.interrupt();
        bobby.interrupt();
    }
}
