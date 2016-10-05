/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.spi;

import org.junit.Test;

/**
 * http://mattiasholmqvist.se/2011/05/loading-clojure-code-with-java-util-serviceloader/
 * 
 * @author Quqing Liu
 */
public class ServiceProviderInterfaceTest {
	
	@Test
	public void loading() {
		new ServiceProviderInterface().loading();
	}

}
