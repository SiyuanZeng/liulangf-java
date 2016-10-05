/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.thread.practice.process;

/**
 * The callback interface for an {@link AsyncProcessor} so that it can
 * notify you when an {@link Exchange} is done.
 * <p/>
 * For example a {@link AsyncProcessor} should invoke the done method when the {@link Exchange} is ready
 * to be continued routed. This allows to implement asynchronous {@link Producer} which can continue
 * routing {@link Exchange} when all the data has been gathered. This allows to build non blocking
 * request/reply communication.
 *
 * @version $Revision: 955853 $
 */
public interface AsyncCallback {

    /**
     * This method is invoked once the {@link Exchange is done}.
     * <p/>
     * If an exception occurred while processing the exchange, the exception field of the
     * {@link Exchange} being processed will hold the caused exception.
     *
     * @param doneSync is <tt>true</tt> if the processing of the {@link Exchange} was completed by the synchronously thread.
     *                 Otherwise its <tt>false</tt> to indicate it was completed by the asynchronously thread.
     */
    void done(boolean doneSync);

}
