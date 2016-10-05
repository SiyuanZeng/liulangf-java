package com.liulangf.thread.pattern.pc;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-8
 */
public class Sleeper {
	
	
	/**
	 * 此方法等价于 Thread.sleep(long);
	 * 
	 * @param x
	 * @throws InterruptedException
	 */
    public static void sleep(long x) throws InterruptedException {
        if (x != 0) {
            Object object = new Object();
            //由于无法从外部获取object 对象的引用
            //因此wait() 无法通过notify() 中断
            synchronized (object) {
                object.wait(x);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("BEGIN");
        try {
            Sleeper.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.out.println("END");
    }

}
