package com.liulangf.io.socket;

/**
 * There are two types of one-to-many service:
 * <ul>
 *   <li>broadcast</li>
 *   <li>multicast</li>
 * </ul>
 * 
 * With broadcast, all hosts on the (local) network receive a copy of the message. 
 * With multicast, the message is sent to a multicast address, and the network delivers it only to those hosts 
 * that have indicated that they want to receive messages sent to that address. 
 * In general, only UDP sockets are allowed to broadcast or multicast.
 * 
 * @author YuQing Liu
 *
 */
public class MultipleRecipient {

}
