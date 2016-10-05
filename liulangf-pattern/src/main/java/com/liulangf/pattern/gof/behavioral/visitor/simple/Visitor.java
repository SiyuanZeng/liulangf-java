package com.liulangf.pattern.gof.behavioral.visitor.simple;

/**
 *
 */
public interface Visitor {
    
    void visit(ElementThis a);//second dispatch
    void visit(ElementThat b);
    void visit(ElementOther c);

}
