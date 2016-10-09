package com.liulangf.tdd.jmock;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 *
 * @author liulangf
 *
 */
//@RunWith(JMock.class)
public class StubTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StubTest.class);

	public final JUnitRuleMockery context = new JUnitRuleMockery();

	@BeforeClass
	public static void before() {
		LOGGER.info("Before class");
	}
	
	@Before
	public void setUp() {
		LOGGER.info("====[{}]\n", this.hashCode());
	}
	
	@Test
	public void test() {
		final Runnable runnable = context.mock(Runnable.class);
		context.checking(new Expectations() {{
			oneOf(runnable).run();
		}});

		runnable.run();
		
		LOGGER.info("test [{}]", this.hashCode());
		LOGGER.info("context [{}]", context.hashCode());
	}
	
	@Test
	public void test2() {
		LOGGER.info("===test2[{}]====", this.hashCode());
		LOGGER.info("context [{}]", context.hashCode());
	}
	
	@Test
	public void testObjectMethod() {
		final A a = context.mock(A.class);
		context.checking(new Expectations() {{
			oneOf(a).toString();
		}});

		a.toString();
	}
	
	@Test
	public void testObjectMethod2() {
		final A a = context.mock(A.class);
		B b = new B();
		b.setA(a);
		context.checking(new Expectations() {{
			oneOf(a).toString();
			will(returnValue("aaa"));
		}});

		String r = b.doA();
		LOGGER.info("===[{}]", r);
	}
	
	class B {
		private A a;
		void setA(A a) {
			this.a = a;
		}
		
		String doA() {
			return a.toString();
		}
		
		
	}

	interface A {
		
	}
}
