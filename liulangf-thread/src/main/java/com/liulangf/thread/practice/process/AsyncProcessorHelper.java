package com.liulangf.thread.practice.process;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * This is a copy from Apache-Camel.
 *  
 * @author Quqing Liu
 */
public final class AsyncProcessorHelper {
    private static final transient Logger LOG = LoggerFactory.getLogger(AsyncProcessorHelper.class);

    private AsyncProcessorHelper() {
        // utility class
    }
    
    /**
     * Calls the async version of the processor's process method.
     * <p/>
     * This implementation supports transacted {@link Exchange}s which ensure those are run in a synchronous fashion.
     * See more details at {@link org.apache.camel.AsyncProcessor}.
     *
     * @param processor the processor
     * @param exchange  the exchange
     * @param callback  the callback
     * @return <tt>true</tt> to continue execute synchronously, <tt>false</tt> to continue being executed asynchronously
     */
    public static boolean process(final AsyncProcessor processor, final Exchange exchange, final AsyncCallback callback) {
        boolean sync;

        if (exchange.isTransacted()) {
            // must be synchronized for transacted exchanges
            LOG.trace("Transacted Exchange must be routed synchronously for exchangeId: {} -> {}", exchange.getExchangeId(), exchange);
            try {
                process(processor, exchange);
            } catch (Throwable e) {
                exchange.setException(e);
            }
            callback.done(true);
            sync = true;
        } else {
            final UnitOfWork uow = exchange.getUnitOfWork();

            // allow unit of work to wrap callback in case it need to do some special work
            // for example the MDCUnitOfWork
            AsyncCallback async = callback;
            if (uow != null) {
                async = uow.beforeProcess(processor, exchange, callback);
            }

            // we support asynchronous routing so invoke it
            sync = processor.process(exchange, async);

            // execute any after processor work (in current thread, not in the callback)
            if (uow != null) {
                uow.afterProcess(processor, exchange, callback, sync);
            }
        }

        if (LOG.isTraceEnabled()) {
            LOG.trace("Exchange processed and is continued routed {} for exchangeId: {} -> {}",
                    new Object[]{sync ? "synchronously" : "asynchronously", exchange.getExchangeId(), exchange});
        }
        return sync;
    }
    
    /**
     * Calls the async version of the processor's process method and waits
     * for it to complete before returning. This can be used by {@link AsyncProcessor}
     * objects to implement their sync version of the process method.
     *
     * @param processor the processor
     * @param exchange  the exchange
     * @throws Exception can be thrown if waiting is interrupted
     */
    public static void process(final AsyncProcessor processor, final Exchange exchange) throws Exception {
        final CountDownLatch latch = new CountDownLatch(1);
        boolean sync = processor.process(exchange, new AsyncCallback() {
            public void done(boolean doneSync) {
                if (!doneSync) {
                    if (LOG.isTraceEnabled()) {
                        LOG.trace("Asynchronous callback received for exchangeId: " + exchange.getExchangeId());
                    }
                    latch.countDown();
                }
            }

            @Override
            public String toString() {
                return "Done " + processor;
            }
        });
        if (!sync) {
            if (LOG.isTraceEnabled()) {
                LOG.trace("Waiting for asynchronous callback before continuing for exchangeId: " + exchange.getExchangeId() + " -> " + exchange);
            }
            latch.await();
            if (LOG.isTraceEnabled()) {
                LOG.trace("Asynchronous callback received, will continue routing exchangeId: " + exchange.getExchangeId() + " -> " + exchange);
            }
        }
    }
}
