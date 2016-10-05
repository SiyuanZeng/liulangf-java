package com.liulangf.thread.pattern.rw;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-8
 */
public class Reader extends Thread {
    private final Data data;
    public Reader(Data data) {
        this.data = data;
    }
    
    public void run() {
        try {
            while (true) {
                char[] readbuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readbuf));
            }
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
    }
	

}
