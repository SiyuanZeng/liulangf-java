/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.thread.practice.process;

/**
 *
 * @author Quqing Liu
 */
public interface Exchange {

	String getExchangeId();
	
	boolean isTransacted();
	
	void setException(Throwable e);
	
	UnitOfWork getUnitOfWork();
}
