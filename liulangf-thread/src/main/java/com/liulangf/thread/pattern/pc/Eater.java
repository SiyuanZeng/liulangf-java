package com.liulangf.thread.pattern.pc;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-8
 */
public class Eater extends Thread {
    private final Random random;
    private final Table table;
    public Eater(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                String cake = table.take();
                TimeUnit.MILLISECONDS.sleep(random.nextInt(5000));
            }
        } catch (InterruptedException e) {
        }
    }
}
