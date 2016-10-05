package com.liulangf.thread.pattern.single;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-7
 */
public class Gate2 {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";
    private final Mutex mutex;
    
    public Gate2(Mutex mutex) {
    	this.mutex = mutex;
    }
    
    public void pass(String name, String address) { // 并非synchronized
        mutex.lock();
        try {
            this.counter++;
            this.name = name;
            this.address = address;
            check();
        } finally {
            mutex.unlock();
        }
    }
    
    @Override
    public String toString() { // 并非synchronized
        String s = null;
        mutex.lock();
        try {
            s = "No." + counter + ": " + name + ", " + address;
        } finally {
            mutex.unlock();
        }
        return s;
    }
    
    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("***** BROKEN ***** " + toString());
        }
    }

}
