package com.liulangf.concurrent.async.callback;

/**
 * Copy from com.google.gwt.user.client.rpc.AsyncCallback.
 * 
 * @param <T>
 *            The type of the return value that was declared in the synchronous
 *            version of the method. If the return type is a primitive, use the
 *            boxed version of that primitive (for example, an <code>int</code>
 *            return type becomes an {@link Integer} type argument, and a
 *            <code>void</code> return type becomes a {@link Void} type
 *            argument, which is always <code>null</code>).
 */

public interface AsyncCallback<T> {
	/**
	 * Called when an asynchronous call fails to complete normally.
	 * {@link IncompatibleRemoteServiceException}s, {@link InvocationException}
	 * s, or checked exceptions thrown by the service method are examples of the
	 * type of failures that can be passed to this method.
	 * 
	 * <p>
	 * If <code>caught</code> is an instance of an
	 * {@link IncompatibleRemoteServiceException} the application should try to
	 * get into a state where a browser refresh can be safely done.
	 * </p>
	 * 
	 * @param caught
	 *            failure encountered while executing a remote procedure call
	 */
	void onFailure(Throwable cause);

	  /**
     * Called when an asynchronous call completes successfully.
     * 
     * @param result
     *            the return value of the remote produced call
     */
	void onSuccess(T result);

}
