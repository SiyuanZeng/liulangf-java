package com.liulangf.pattern.gof.behavioral.visitor.simple;

/**
 *
 */
public class ElementOther implements Element {

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    public String other() {
        return "other";
    }
   
}
