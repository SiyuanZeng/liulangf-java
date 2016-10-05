package com.liulangf.pattern.gof.behavioral.visitor.simple;

/**
 *
 */
public interface Element {
    
    //First dispatch
    void accept(Visitor visitor);

}
