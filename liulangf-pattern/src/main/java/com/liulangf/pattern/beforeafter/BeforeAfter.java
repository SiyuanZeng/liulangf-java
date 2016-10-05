package com.liulangf.pattern.beforeafter;

/**
 * 使用分层(layering)策略来控制程序的行为机制是一种常见的结构化法则。
 * before/after 模式 的基本结构 
 * 
 * before();
 * try {
 *     business();
 * } finally {
 *     after();
 * }
 * 
 * @author LiuYuQing
 * @version 1.0 2010-11-9
 */
public interface BeforeAfter {
	
	public void before();
	public void business();
	public void after();

}
