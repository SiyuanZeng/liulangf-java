package com.liulangf.thread.pattern.single;

import java.util.concurrent.TimeUnit;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-7
 */
public class User extends Thread {
	private final Gate gate;
    private final String myname;
    private final String myaddress;
    
    public User(Gate gate, String myname, String myaddress) {
        this.gate = gate;
        this.myname = myname;
        this.myaddress = myaddress;
    }
    
    @Override
    public void run() {
        System.out.println(myname + " BEGIN");
        while (true) {
        	try {
				TimeUnit.SECONDS.sleep(1);
				gate.pass(myname, myaddress);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }

}
