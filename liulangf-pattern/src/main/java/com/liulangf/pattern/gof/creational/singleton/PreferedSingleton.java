package com.liulangf.pattern.gof.creational.singleton;

/**
 * <<Effective Java2>> Chapter2 Item3
 * A single-element enum type is the best way to implement a singleton
 * 
 * @author Quqing Liu
 */
public enum PreferedSingleton {

}
enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
