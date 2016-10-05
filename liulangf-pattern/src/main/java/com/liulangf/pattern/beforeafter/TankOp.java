package com.liulangf.pattern.beforeafter;

/**
 * 用来实现before/after 最灵活也是最笨拙的方法是使用方法适配器。 
 * 类似command pattern。 将command 作为参数传递。
 * 
 * @author LiuYuQing
 * @version 1.0 2010-11-10
 */
public interface TankOp {
	void op() throws OverflowException, UnderflowExceptoin;
}
