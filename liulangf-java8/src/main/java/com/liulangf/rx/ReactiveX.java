package com.liulangf.rx;

import rx.Observable;
import rx.functions.Action1;

/**
 * http://reactivex.io
 * 
 * An API for asynchronous programming with observable streams.
 * 
 * Rx: Reactive Extension.
 * 
 * ReactiveX is a library for composing asynchronous and event-based programs by using observable sequences.
 * 
 * It extends the observer pattern to support sequences of data and/or events and adds operators 
 * that allow you to compose sequences together declaratively while abstracting away concerns about 
 * things like low-level threading, synchronization, thread-safety, concurrent data structures, and non-blocking I/O.
 * 
 */
public class ReactiveX {

	
	public static void hello(String... names) {
		Observable.from(names).subscribe(new Action1<String>() {
			public void call(String s) {
				System.out.println("hello " + s + "!");
			}
		});
		
		Observable.from(names).subscribe(s -> {
			System.out.println("hello " + s + "!");
		});
		
	}
}
