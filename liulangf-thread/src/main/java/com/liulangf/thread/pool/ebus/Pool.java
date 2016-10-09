package com.liulangf.thread.pool.ebus;

/**
 * 对象池接口
 */
public interface Pool<T> {
    T get() throws Exception;
    void put(T object) throws Exception;
}
