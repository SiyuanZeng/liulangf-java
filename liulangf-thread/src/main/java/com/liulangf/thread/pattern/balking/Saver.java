package com.liulangf.thread.pattern.balking;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-7
 */
public class Saver extends Thread {
	
    private Data data;
    public Saver(String name, Data data) {
        super(name);
        this.data = data;
    }
    public void run() {
        try {
            while (true) {
                data.save();            // 存储资料
                TimeUnit.SECONDS.sleep(1);// 休息约1秒
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
