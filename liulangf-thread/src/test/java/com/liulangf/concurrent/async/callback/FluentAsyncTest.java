/*
 * 版权所有:(C)2001-2012 北京中油瑞飞信息技术有限责任公司
 */
package com.liulangf.concurrent.async.callback;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.http.client.fluent.Async;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.concurrent.FutureCallback;
import org.junit.Test;

/**
 * This example demonstrates how the he HttpClient fluent API can be used to execute multiple
 * requests asynchronously using background threads.
 * 
 * @author YuQing Liu
 *
 */
public class FluentAsyncTest {
	
	// Use pool of two threads
    private ExecutorService threadpool = Executors.newFixedThreadPool(2);
    private Async async = Async.newInstance().use(threadpool);
    

	@Test
	public void test() throws InterruptedException {
        Request[] requests = new Request[] {
                Request.Get("http://www.google.com/"),
                Request.Get("http://www.yahoo.com/"),
                Request.Get("http://www.apache.com/"),
                Request.Get("http://www.apple.com/")
        };
        
        Queue<Future<Content>> queue = new LinkedList<Future<Content>>();
        
        // Execute requests asynchronously
        for (final Request request: requests) {
            Future<Content> future = async.execute(request, new FutureCallback<Content>() {
                
                public void failed(final Exception ex) {
                    System.out.println(ex.getMessage() + ": " + request);
                }
                
                public void completed(final Content content) {
                    System.out.println("Request completed: " + request);
                }
                
                public void cancelled() {
                }
                
            });
            queue.add(future);
        }

        while(!queue.isEmpty()) {
            Future<Content> future = queue.remove();
            try {
                Content content = future.get();
                System.out.println(content.asString());
            } catch (ExecutionException ex) {
            }
        }
        System.out.println("Done");
        threadpool.shutdown();
	}

}
