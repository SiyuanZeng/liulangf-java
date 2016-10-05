package com.liulangf.thread.pattern.pc;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-8
 */
public class Maker extends Thread {
    private final Random random;
    private final Table table;
    private static int id = 0; //  蛋糕的流水号(所有厨师共通)
    public Maker(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }
    public void run() {
        try {
            while (true) {
            	TimeUnit.MILLISECONDS.sleep(random.nextInt(5000));
                String cake = "[ Cake No." + nextId() + " by " + getName() + " ]";
                table.put(cake);
            }
        } catch (InterruptedException e) {
        }
    }
    private static synchronized int nextId() {
        return id++;
    }
}
