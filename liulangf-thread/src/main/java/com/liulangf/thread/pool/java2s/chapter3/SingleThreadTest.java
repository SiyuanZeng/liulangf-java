package com.liulangf.thread.pool.java2s.chapter3;

/**
 *
 */
public class SingleThreadTest {
    public static void main(String[] args) {
        int nTasks = 5;
        int fib = 4;
        SingleThreadAccess sta = new SingleThreadAccess();
        for (int i = 0; i < nTasks; i++)
          sta.invokeLater(new Task(fib, "Task " + i));
        sta.shutdown();
      }
}
