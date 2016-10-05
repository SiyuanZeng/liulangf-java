package com.liulangf.pattern.gof.behavioral.visitor.simple;

/**
 *
 */
public class ElementThat implements Element {

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    public String that() {
        return "that";
    }
}
