package com.liulangf.thread.pool.camel;

/**
 * Reject executing or processing some task.
 */
public interface Rejectable {

    /**
     * The task was rejected.
     */
    void reject();

}
