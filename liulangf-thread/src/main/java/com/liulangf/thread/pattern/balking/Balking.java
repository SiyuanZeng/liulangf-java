package com.liulangf.thread.pattern.balking;

import java.util.concurrent.TimeUnit;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-7
 */
public class Balking {
	
    public static void main(String[] args) throws Exception {
        Data data = new Data("data.txt", "(empty)");
        Thread changer = new Changer("ChangerThread", data);
        Thread saver = new Saver("SaverThread", data);
        
        changer.start();
        saver.start();
        
        TimeUnit.SECONDS.sleep(10);
        
        changer.interrupt();
        saver.interrupt();
    }

}
