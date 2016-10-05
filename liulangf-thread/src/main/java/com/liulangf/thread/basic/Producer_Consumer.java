/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.thread.basic;

/**
 * One of the classic problems in synchronization is called producer-consumer problem, as known as the
 * bounded buffer problem. One or more producers (threads or processes) are creating data items that are
 * then processed by one or more consumers(threads or processes). The data items are passed between the 
 * producers and consumers using some type of IPC.
 * 
 * When shared memory is being used as the form of IPC between producer and the consumer, however, some
 * type of explicit synchronization must be performed by the producers and consumers.
 *
 * @author Quqing Liu
 */
@Coordination
interface Producer_Consumer {
	//spinning : 自旋锁
	//polling  ：轮询
}