package com.liulangf.pattern.gof.behavioral.visitor.simple;

/**
 *
 */
public class VisitorB implements Visitor {

    @Override
    public void visit(ElementThis a) {
        System.out.println("visitorb visit a");
    }

    @Override
    public void visit(ElementThat b) {
        System.out.println("visitorb visit b");
    }

    @Override
    public void visit(ElementOther c) {
        System.out.println("visitorc visit c");
    }

}
