/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.thread.practice.process;


/**
 * An <b>asynchronous</b> processor which can process an {@link Exchange} in an asynchronous fashion
 * and signal completion by invoking the {@link AsyncCallback}.
 * <p/>
 * Any processor can be coerced to have an {@link AsyncProcessor} interface by using the
 * {@link org.apache.camel.impl.converter.AsyncProcessorTypeConverter#convert AsyncProcessorTypeConverter.covert}
 * method.
 * <p/>
 * <b>Important:<b/> Use the {@link org.apache.camel.util.AsyncProcessorHelper#process(AsyncProcessor, Exchange, AsyncCallback)}
 * method to invoke the process method, which ensure Camel have a chance to interweave and invoke it in a reliable manner.
 * For example when using transactions all the invocations has to occur in synchronous manner to ensure the transaction
 * work is done in the same thread, which is required by Spring TransactionManager.
 *
 * @version $Revision: 1004899 $
 */
public interface AsyncProcessor {

    /**
     * Processes the message exchange.
     * Similar to {@link Processor#process}, but the caller supports having the exchange asynchronously processed.
     * <p/>
     * If there was a failure processing then the caused {@link Exception} would be set on the {@link Exchange}.
     *
     * @param exchange the message exchange
     * @param callback the {@link AsyncCallback} will be invoked when the processing of the exchange is completed.
     *                 If the exchange is completed synchronously, then the callback is also invoked synchronously.
     *                 The callback should therefore be careful of starting recursive loop.
     * @return (doneSync) <tt>true</tt> to continue execute synchronously, <tt>false</tt> to continue being executed asynchronously
     * @see org.apache.camel.util.AsyncProcessorHelper#process(AsyncProcessor, Exchange, AsyncCallback)
     */
    boolean process(Exchange exchange, AsyncCallback callback);
}
