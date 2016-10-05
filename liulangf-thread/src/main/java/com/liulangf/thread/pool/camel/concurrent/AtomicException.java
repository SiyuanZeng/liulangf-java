package com.liulangf.thread.pool.camel.concurrent;


import java.util.concurrent.atomic.AtomicReference;

/**
 * Convenience class for holding an {@link Exception} in a thread-safe way
 */
@SuppressWarnings("serial")
public class AtomicException extends AtomicReference<Exception> {

}
