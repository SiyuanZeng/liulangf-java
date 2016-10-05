package com.liulangf.io.buffer;


/**
 * The nonbyte primitive types, except for boolean, are composed of several bytes grouped together. 
 * <ul>
 *  <li>Byte	1</li>
 *  <li>Char	2</li>
 *  <li>Short	2</li>
 *  <li>Int		4</li>
 *  <li>Long	8</li>
 *  <li>Float	4</li>
 *  <li>Double	8</li>
 * </ul>
 *
 */
public class ByteOrdering {
	
	private java.nio.ByteOrder big = java.nio.ByteOrder.BIG_ENDIAN;
	private java.nio.ByteOrder litter = java.nio.ByteOrder.LITTLE_ENDIAN;

}
