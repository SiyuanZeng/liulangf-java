package com.liulangf.tdd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Waiting {
	
	private static final transient Logger LOGGER = LoggerFactory.getLogger(Waiting.class);
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public void waiting() throws java.io.IOException {
		LOGGER.info("\n==I'm waiting!==");
		reader.readLine();
	}

}
