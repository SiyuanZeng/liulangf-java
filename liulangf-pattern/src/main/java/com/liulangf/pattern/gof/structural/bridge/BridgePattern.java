package com.liulangf.pattern.gof.structural.bridge;

/**
 * Bridge 两个不同的类层次结构。
 * 
 * There are two basic strategies to follow in creating designs to deal with the variations:
 *   Find what varies and encapsulate it.
 *   Favor aggregation over inheritance.
 *
 */
public interface BridgePattern {
    
    /**
     *  Print drivers are perhaps the class example of the Bridge.
     */
    void print_driver();

}
