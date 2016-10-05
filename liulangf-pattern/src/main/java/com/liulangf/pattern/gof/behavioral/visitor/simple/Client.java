package com.liulangf.pattern.gof.behavioral.visitor.simple;

/**
 *
 */
public class Client {

    public static void main(String...args) {
        VisitorA a = new VisitorA();
        VisitorB b = new VisitorB();
        Element[] list = {
            new ElementThis(), new ElementThat(), new ElementOther()      
        };
        
        //遍历元素，并accept visitor
        for (Element e : list) {
            e.accept(a);
        }
        
        for (Element e : list) {
            e.accept(b);
        }
    }
}
