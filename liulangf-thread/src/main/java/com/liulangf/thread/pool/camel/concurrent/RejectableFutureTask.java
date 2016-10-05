package com.liulangf.thread.pool.camel.concurrent;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import com.liulangf.thread.pool.camel.Rejectable;


/**
 * A {@link Rejectable} {@link FutureTask} used by {@link RejectableThreadPoolExecutor}.
 *
 * @see RejectableThreadPoolExecutor
 */
public class RejectableFutureTask<V> extends FutureTask<V> implements Rejectable {

    private final Rejectable rejectable;

    public RejectableFutureTask(Callable<V> callable) {
        super(callable);
        this.rejectable = callable instanceof Rejectable ? (Rejectable) callable : null;
    }

    public RejectableFutureTask(Runnable runnable, V result) {
        super(runnable, result);
        this.rejectable = runnable instanceof Rejectable ? (Rejectable) runnable : null;
    }

    @Override
    public void reject() {
        if (rejectable != null) {
            rejectable.reject();
        }
    }

}
