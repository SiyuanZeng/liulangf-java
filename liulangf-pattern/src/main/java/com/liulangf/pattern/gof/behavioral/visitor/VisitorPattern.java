package com.liulangf.pattern.gof.behavioral.visitor;

/**
 * <p> Intent from GOF.
 * Represent an operation to be performed on the elements of an object structure. 
 * Visitor lets you define a new operation without changing the classes of the 
 * elements on which it operates.
 * 
 * <p>Here are two other implementation issues that arise when you apply the Visitor pattern:
 * <ul>
 *   <li>Double dispatch</li>
 *   <li>Who is responsible for traversing the object structure?</li>
 * </ul>
 *
 * <p>Double dispatch:
 * Effectively, the Visitor pattern lets you add operations to classes without changing them. 
 * Visitor achieves this by using a technique called double-dispatch.
 */
public interface VisitorPattern {

}
