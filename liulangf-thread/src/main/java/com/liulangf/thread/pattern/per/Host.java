package com.liulangf.thread.pattern.per;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-9
 */
public class Host {
    private final Helper helper = new Helper();
    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        //thread per message
        new Thread() {
        	@Override
            public void run() {
                helper.handle(count, c);
            }
        }.start();
        
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
