package com.liulangf.pattern.gof.behavioral.visitor.simple;

/**
 *
 */
public class ElementThis implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String thiss() {
        return "this";
    }
}
