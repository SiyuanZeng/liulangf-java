package com.liulangf.thread.pattern.active;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-13
 */
public interface ActiveObject {
    public abstract Result makeString(int count, char fillchar);
    public abstract void displayString(String string);
}
