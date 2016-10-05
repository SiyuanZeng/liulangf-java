package com.liulangf.thread.pattern.suspension;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-7
 */
public class Request {
    private final String name;
    public Request(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return "[ Request " + name + " ]";
    }
}
