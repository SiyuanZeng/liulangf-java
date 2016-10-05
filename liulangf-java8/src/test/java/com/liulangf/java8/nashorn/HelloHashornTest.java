package com.liulangf.java8.nashorn;

import java.util.stream.Stream;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jdk.nashorn.internal.parser.TokenType;

public class HelloHashornTest {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@Test
	public void test() {
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine nashorn = sem.getEngineByName("nashorn");
		
		try {
			nashorn.eval("(function() { print('good morning'); }());");
		} catch(ScriptException e) {
			log.error("", e);
		}
	}
	
	@Test
	public void tokenTest() {
	    final int tableBase = ' ';
	    int tableLimit = '~';
	    int tableLength = tableLimit - tableBase + 1;
	    
	    for (int i = tableBase; i <= tableLimit; i++ ) {
	    	log.info("{}", (char)i);	
	    }
	    
	    log.info("{}", tableLength);
	}
	
	@Test
	public void tokenTypeTest() {
		for (TokenType t : TokenType.values()) {
			log.info("{}", t);
		}
	}
	
	@Test
	public void tokenLookupTest() {
		TokenLookup.table();
		Stream<TokenType> stream = Stream.of(TokenLookup.table()).filter(t -> t != null);
		stream.forEach(t -> {
			StringBuilder sb = new StringBuilder();
			sb.append(t.toString());
			
			TokenType n = t.getNext();
			
			while (n != null) {
				sb.append(" -> ");
				sb.append(n.toString());
				n = n.getNext();
			}
			
			log.info("{}", sb.toString());
		});
	}

}
