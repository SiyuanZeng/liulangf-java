/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.thread.java6;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Quqing Liu
 */
public class ThreadPool {
	
	
	/**
	 * ThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
long keepAliveTime, TimeUnit unit,
BlockingQueue<Runnable> workQueue,
RejectedExecutionHandler handler)

corePoolSize： 线程池维护线程的最少数量
maximumPoolSize：线程池维护线程的最大数量
keepAliveTime： 线程池维护线程所允许的空闲时间
unit： 线程池维护线程所允许的空闲时间的单位
workQueue： 线程池所使用的缓冲队列
handler： 线程池对拒绝任务的处理策略

当一个任务通过execute(Runnable)方法欲添加到线程池时：

如果此时线程池中的数量小于corePoolSize，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理被添加的任务。

如果此时线程池中的数量等于 corePoolSize，但是缓冲队列 workQueue未满，那么任务被放入缓冲队列。

如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量小于maximumPoolSize，建新的线程来处理被添加的任务。

如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量等于maximumPoolSize，那么通过 handler所指定的策略来处理此任务。

也就是：处理任务的优先级为：
核心线程corePoolSize、任务队列workQueue、最大线程maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。

当线程池中的线程数量大于 corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，线程池可以动态的调整池中的线程数。

handler有四个选择：
ThreadPoolExecutor.AbortPolicy()
抛出java.util.concurrent.RejectedExecutionException异常
ThreadPoolExecutor.CallerRunsPolicy()
重试添加当前的任务，他会自动重复调用execute()方法
ThreadPoolExecutor.DiscardOldestPolicy()
抛弃旧的任务
ThreadPoolExecutor.DiscardPolicy()
抛弃当前的任务

	 */
	public void customExecutor() {
		
		//ThreadPoolExecutor with 10 threads, and a request queue with a limit of 100 pending requests.
		Executor executor = 
			new ThreadPoolExecutor(10, 50, 50000L, TimeUnit.MILLISECONDS, 
					new LinkedBlockingQueue<Runnable>(100));
		executor.execute(new Runnable() {
			public void run() {
				
			}
		});
		
	}

}
