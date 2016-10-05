package com.liulangf.pattern.gof.structural.decorator;

/**
 * A Decorator uses Object Recursion to traverse a chain of objects, 
 * presumably at least two in length, and perform the same method call on each.
 */
public interface Decorator_and_recursion {
    
    /**
     * 1.base case(the termination)
     * 2.recursive call
     */
    void recursion();
    
    /**
     * 1.concrete class(the base case or the termination)
     * 2.recursive call to the same type.
     */
    void decorator();

}
