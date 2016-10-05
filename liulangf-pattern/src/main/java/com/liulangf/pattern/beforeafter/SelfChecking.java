package com.liulangf.pattern.beforeafter;

/**
 * 契约编程规范：通过在类的每一个公共方法的入口和出口同时对不变约束进行检查，可以动态的检查
 * 程序是否遵循了这些可计算的不变约束。
 * 
 * 对于现有的系统,可以用三种before/after 设计模式可以将这些检查方法和基础方法分隔开来。
 * 1: 适配器(adapter class)
 * 2: 子类化
 * 3：方法适配类(method adapter class)
 * 
 * 
 * @author LiuYuQing
 * @version 1.0 2010-11-9
 */
public interface SelfChecking {
	
	//self contained
	//自足的,自我满意的

}
