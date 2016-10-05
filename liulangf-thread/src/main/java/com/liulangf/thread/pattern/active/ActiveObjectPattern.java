package com.liulangf.thread.pattern.active;

import java.util.concurrent.TimeUnit;

/**
 * Active Object : An Object Behavioral Pattern for Concurrent Programming.
 * Active Object Pattern decouples method execution from method invocation in order
 * to simplify synchronized access to an object that resides in its own thread of control.
 * This pattern is commonly used in distributed systems requiring multi-threaded servers.
 * 
 * @author LiuYuQing
 * @version 1.0 2010-7-13
 */
public class ActiveObjectPattern {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        MakerClientThread alice = new MakerClientThread("Alice", activeObject);
        MakerClientThread bobby = new MakerClientThread("Bobby", activeObject);
        DisplayClientThread chris = new DisplayClientThread("Chris", activeObject);
        
        alice.start();
        bobby.start();
        chris.start();
        
        try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		alice.interrupt();
//		bobby.interrupt();
//		chris.interrupt();
		
		System.out.println("==============Over!============");
        
    }
}
