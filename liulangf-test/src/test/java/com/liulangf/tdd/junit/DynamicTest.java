package com.liulangf.tdd.junit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.fest.util.Strings;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicTest {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	private String name = "";
	
	@Before
	public void before() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		log.info("Please input test context: [Prod]/[Test]");
		String cmd = reader.readLine();
		log.info("cmd: {}", cmd);
		name = cmd;
		if (!cmd.equals("Prod")) {
			throw new RuntimeException("Error!");
		}
	}

	@Test
	public void test() {
		log.info("name is : {}", name);
	}
	
	@Test
	public void cmdTest() {
		log.info("name is : {}", name);
	}

}
