package com.liulangf.pattern.gof.behavioral.visitor.simple;

/**
 *
 */
public class VisitorA implements Visitor {

    @Override
    public void visit(ElementThis a) {
        System.out.println("visitora visit a");
    }

    @Override
    public void visit(ElementThat b) {
        System.out.println("visitora visit b");
    }

    @Override
    public void visit(ElementOther c) {
        System.out.println("visitora visit c");
    }

}
