package com.liulangf.thread.wenshao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author LiuYuQing
 * @version 1.0 2010-11-12
 */
public class LockFrees {
//putIfAbsent
}

class SyncBeanManager {
	private Map<String, Object> map = new HashMap<String, Object>();
	
	public Object getBean(String key) {
		synchronized (map) {
			Object bean = map.get(key);
			if (bean == null) {
				bean = createBean();
				map.put(key, bean);
				bean = map.get(key);
			}
			return bean;
		}
	}
	
	public Object createBean() {
		return null;
	}
}

class LockFreeBeanManager {
	private ConcurrentMap<String, Object> map = new ConcurrentHashMap<String, Object>();
	
	public Object getBean(String key) {
		Object bean = map.get(key);
		if (bean == null) {
			map.putIfAbsent(key, createBean());
			bean = map.get(key);
		}
		return bean;
	}
	
	public Object createBean() {
		return null;
	}
}
