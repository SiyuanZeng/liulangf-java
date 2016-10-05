/*************************************************************************
* Copyright (c) 2006-2012 www.liulangf.com
* All Rights Reserved.
*
*************************************************************************/
package com.liulangf.pattern.common;

/**
 * 正交性
 * Orthogonality is a critical concept if you want to produce systems that are easy to design, build, test, and extend.
 * Orthogonality is a term borrowed from geometry. Two lines are orthogonal if they meet at right angels, such as the 
 * axes on graph.(两条线相交成直角则他们是正交的，如坐标轴。) In vector terms, the two lines are independent.(他们是独立的，
 * 相互不依赖对方的。) Move along one of the lines, and your position projected onto the other doesn't change.
 * 
 * In computing, the term has come to signify a kind of independence or decoupling. Two or more things are othogonality
 * if changes in one do not affect any of the others.
 * 
 * Eliminate Effects Between Unrelated Things.消除无关事物之间的纠葛。
 * 
 * We want to design components that are self-contained(自足的): independent, and with a single, well-defined purpose(
 * what Yourdon and Constantine call cohesion(内聚度))。When components are isolated from one another, you know that
 * you can change one without having to worry about the rest. As long as you don't change that component's external
 * interfaces, you can be comfortable that you won't cause problems that ripple(涟漪) through the entire system.
 * 
 *  
 * @author LiuYuqing
 */
public class Orthogonality {

}
