package com.liulangf.thread.java6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**COW(写时才copy) 是一种古老的技术，类似的并发数据结构有：
 * ConcurrentSkipListMap
 * ConcurrentSkipListSet
 * CopyOnWriteArrayList
 * CopyOnWriteArraySet
 * 
 * 适当使用CopyOnWriteXXX 能有效提高读操作时的效率。 
 * CopyOnWriteArrayList 和 CopyOnWriteArraySet ，
 * 最适合于读操作通常大大超过写操作的情况。
 * 一个最常提到的例子是使用监听器列表。
 * 
 * Copy-on-write (sometimes referred to as "COW") is an optimization strategy used in computer programming. 
 * The fundamental idea is that if multiple callers ask for resources which are initially indistinguishable, 
 * you can give them pointers to the same resource. 
 * This function can be maintained until a caller tries to modify its "copy" of the resource, 
 * at which point a true private copy is created to prevent the changes becoming visible to everyone else. 
 * All of this happens transparently to the callers. The primary advantage is that 
 * if a caller never makes any modifications, no private copy need ever be created.
 * 
 * Copy On Write是这样一种机制。当我们读取共享数据的时候，直接读取，不需要同步。
 * 当我们修改数据的时候，我们就把当前数据Copy一份副本，然后在这个副本上进行修改，完成之后，
 * 再用修改后的副本，替换掉原来的数据。这种方法就叫做Copy On Write。 
 * 
 * @author LiuYuQing
 * @version 1.0 2010-11-12
 */
public class CopyOnWrites {
	
	//1.......
	private List<Listener> listeners = new ArrayList<Listener>();
	public boolean addListener(Listener listener) {
		synchronized (listeners) {
			return listeners.add(listener);
		}
	}
	
	public void doHandle() {
		synchronized (listeners) {
			for (Listener l : listeners) {
				l.handle();
			}
		}
	}
	
	//2.......
	private List<Listener> lists = new CopyOnWriteArrayList<Listener>();
	
	public boolean add(Listener l) {
		return lists.add(l);
	}
	
	public void handle() {
		for (Listener l : lists) {
			l.handle();
		}
	}
	
	/*
	 * the source from CopyOnWriteArrayList.
	 * 只有修改时才进行copy操作。
	public boolean add(E e) {
		final ReentrantLock lock = this.lock;
		lock.lock();
		try {
		    Object[] elements = getArray();
		    int len = elements.length;
		    Object[] newElements = Arrays.copyOf(elements, len + 1);
		    newElements[len] = e;
		    setArray(newElements);
		    return true;
		} finally {
		    lock.unlock();
		}
	}
	*/

}

interface Listener {
	public void handle();
}

