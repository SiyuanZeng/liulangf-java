package com.liulangf.pattern.iod;

/**
 * To successfully use an interface, both the caller and implementer need
 * to understand the contract-- what the implementation agrees to do for
 * the caller.
 * 
 *  Bertrand Meyer popularized Design by Contract in his book 
 *  Object-Oriented Software Construction (Prentice Hall, 1997).
 *  He introduces three facets to a contract-preconditions, postconditions,
 *  and class invariants(不变式).
 *  
 *  The class invariant describes the conditions that every object instance
 *  must satisfy. When dealing with interfaces, these class invariants are 
 *  typically properties of a particular implementation, not of the interface 
 *  methods.
 *  
 *  Design to an interface, not an implementation.
 *  Test to an interface, not an implementation. (This is termed black box testing.)
 *  
 *  Data interfaces and service interfaces:
 *  Entities, Control, Boundary:
 *  In Object-oriented software engineering, Ivar Jacobsen introduced three
 *  stereotypes for objects: entity, boundary, and control.
 *  
 * @author LiuYuQing
 * @version 1.0 2010-12-20
 */
public class DesignByContract {

}
