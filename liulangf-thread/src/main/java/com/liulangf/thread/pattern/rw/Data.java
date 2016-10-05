package com.liulangf.thread.pattern.rw;

import java.util.concurrent.TimeUnit;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-8
 */
public class Data {
	private final char[] buffer;
	private final ReadWriteLock lock = new ReadWriteLock();
	
	public Data(int size) {
		buffer = new char[size];
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = '*';
		}
	}

	public char[] read() throws InterruptedException {
		lock.readLock();
		try {
			return doRead();
		} finally {
			lock.readUnlock();
		}
	}
	
	public void write(char c) throws InterruptedException {
		lock.writeLock();
		try {
			doWrite(c);
		} finally {
			lock.writeUnlock();
		}
	}
	
	private char[] doRead() {
		char[] nb = new char[buffer.length];
		for (int i = 0; i < buffer.length; i++) {
			nb[i] = buffer[i];
		}
		slowly();
		return nb;
	}
	
	private void doWrite(char c) {
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = c;
			slowly();
		}
	}
	
	private void slowly() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
