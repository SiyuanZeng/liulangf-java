package com.liulangf.tdd.jmock;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * Mocking Classes with jMock and the ClassImposteriser.
 * 
 * jmock-legacy-2.5.1.jar, cglib-nodep-2.1_3.jar and objenesis-1.0.jar are needed.
 * 
 * @author LiuYuQing
 */
@RunWith(JMock.class)
public class ConcreteClassTest {
	
	private final static String SNS_AUTH_SCHEMA = "sns_auth_schema";

	//
	private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
    
    @Rule
	public ExpectedException exception = ExpectedException.none();
    
    private SignatureHandler handler;
    private MockHttpServletRequest request;
    private SnsAuthSchema schema;
    
    @Before
    public void setUp() {
    	handler = new SignatureHandler();
    	request = new MockHttpServletRequest();
    	//mock concrete class
    	schema = context.mock(SnsAuthSchema.class);
    	request.setAttribute(SNS_AUTH_SCHEMA, schema);
    }
    
    
    @Test 
    public void apiKeyNotNullCheck() throws Exception {
    	context.checking(new Expectations() {{
    		oneOf(schema).getApiKey();
    		will(returnValue(null));
    	}});
    	
    	exception.expect(SignatureException.class);
		exception.expectMessage("Api key needed!");
    	
    	handler.authCheck(request);
    }

    
    @Test 
    public void apiKeyErrorCheck() throws Exception {
    	context.checking(new Expectations() {{
    		oneOf(schema).getApiKey();
    		will(returnValue("not equals to hello_tdd"));
    	}});
    	
    	exception.expect(SignatureException.class);
		exception.expectMessage("Api key error!");
    	handler.authCheck(request);
    }
    
}
