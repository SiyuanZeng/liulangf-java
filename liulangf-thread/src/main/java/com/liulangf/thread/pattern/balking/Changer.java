package com.liulangf.thread.pattern.balking;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-7
 */
public class Changer extends Thread {
    private Data data;
    private Random random = new Random();
    public Changer(String name, Data data) {
        super(name);
        this.data = data;
    }
    public void run() {
        try {
            for (int i = 0; true; i++) {
                data.change("No." + i);             //修改资料
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));// 模拟去做别的事情
                data.save();                        // 明确的要求存档
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
