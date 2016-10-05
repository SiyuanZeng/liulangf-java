/**
* 版权所有:(C)2001-2012 北京中油瑞飞信息技术有限责任公司
* Author : 刘余庆
* Creation time : 2012-11-6 下午2:44:46
* Description :
*/
package com.liulangf.thread.pool.ebus;

/**
 * 对象池接口
 */
public interface Pool<T> {
    T get() throws Exception;
    void put(T object) throws Exception;
}
