/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.tdd.junit;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Quqing Liu
 */
public class CatSonTest extends CatTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(CatSonTest.class);
	
	@Before
	public void prepare() {
		LOGGER.info("==[Order.No.2] Prepare something before test starts.==");
	}

	@Before
	public void ready() {
		LOGGER.info("==[Order.No.3] This is the setUp from CatSonTest==");
	}
	
	@Test
	public void interesting() {
		LOGGER.info("");
	}
	
	@Test
	public void anotherWork() {
	}
}
