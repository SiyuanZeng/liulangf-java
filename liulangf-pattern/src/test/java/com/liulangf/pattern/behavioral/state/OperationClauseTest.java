package com.liulangf.pattern.behavioral.state;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.liulangf.pattern.gof.behavioral.state.OperationClause;
import com.liulangf.pattern.gof.behavioral.state.ServiceInfo;

public class OperationClauseTest {
	

	private ServiceInfo service;
	private OperationClause operationClause;
	
	@Before
	public void setUp() {
		service = new ServiceInfo();
		operationClause = new OperationClause(service).name("helloWorld");
	}
	
	@After
	public void tearDown() {
		operationClause = null;
		service = null;
	}
	
	@Test
	public void statePattern() {
		
		operationClause
		    .input()
		        .args("arg0", "string")
		        .args("arg1", "int")
		    .output()
		        .args("arg0", "string")
		        .args("arg1", "int")
		    .input()
		        .args("arg2", "int")
		        .args("arg3", "string")
		    .output()
		        .args("arg2", "int")
		    .input()
		        .args("arg4", "int");
	}

}
