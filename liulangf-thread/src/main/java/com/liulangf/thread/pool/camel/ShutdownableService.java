package com.liulangf.thread.pool.camel;

/**
 * A {@link org.apache.camel.Service} which is capable of being shut down.
 * <p/>
 * This is useful for services which need more fine grained control when the {@link CamelContext} is shutting down.
 * This allows customization of behavior when stopping or shutting down.
 * <p/>
 * For example to shutdown thread pools during shutdown and <b>not</b> at CamelContext termination.
 *
 * @version 
 */
public interface ShutdownableService {

    /**
     * Shutdown the service, which means it cannot be started again.
     *
     * @throws Exception thrown if shutting down failed
     */
    void shutdown() throws Exception;

}