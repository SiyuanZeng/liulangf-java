package com.liulangf.thread.pool.book;

/**
 * From the book <<Java Thread Programming>> chapter 13.
 * 
 * <p>
 * When design situations arise that could benefit by using many short-lived threads, thread pooling is a 
 * useful technique. Rather than create a brand new thread for each task, you can have one of the threads 
 * from the thread pool pulled out of the pool and assigned to the task. When the thread is finished with 
 * the task, it adds itself back to the pool and waits for another assignment.
 * 
 * <p>
 * All the threads are started, and then each goes into a wait state (which uses very few processor resources) 
 * until a task is assigned to it. 
 * 
 * <p>
 * Thread pooling works only when the tasks are relatively short-lived. 
 * @author liulangf
 *
 */
public class JavaThreadPooling {
	
	

}
