package com.liulangf.thread.pattern.single;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-7
 */
public class SingleThreadedExecution {
    public static void main(String[] args) {
        System.out.println("Testing Gate, hit CTRL+C to exit.");
        Gate gate = new Gate();
        new User(gate, "Alice", "Alaska").start();
        new User(gate, "Bobby", "Brazil").start();
        new User(gate, "Chris", "Canada").start();
    }

}
