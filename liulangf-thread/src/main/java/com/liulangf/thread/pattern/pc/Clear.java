package com.liulangf.thread.pattern.pc;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-8
 */
public class Clear extends Thread {

    private final Table table;
    public Clear(String name, Table table) {
        super(name);
        this.table = table;
    }
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                System.out.println("===== " + getName() + " clears =====");
                //table.clear();
            }
        } catch (InterruptedException e) {
        }
    }
	
}
