package com.liulangf.tdd;

/**
 * Only ever write code to fix a failing test. This is TDD.
 * 
 * Techniques for Improving Testability:
 * <ul>
 *   <li> Code to interfaces rather than classes
 *   <li> Use the Strategy design pattern
 *   <li> Consider the Law of Demeter(http://c2.com/cgi/wiki?LawOfDemeter)
 *   <li> Minimize dependence on environment-specific APIS
 *   <li> Give each object a manageable and consistent set of responsibilities
 *   <li> Hide implementation details
 *   <li> Refactor into methods to allow overriding at test time
 * </ul>
 * 
 * @author LiuYuQing
 */
public class WriteTestableCodes {
	

	/**
	 * <ul>
	 *   <li>EJB is hard to test.</li>
	 *   <li>Singleton is anti-pattern. It is an evil for testing.</li>
	 *   <li>static Facade is hard for testing</li>
	 * </ul>
	 */
	public void unTestable() {
	}
	
	//-------- A simple demo for using Strategy design pattern 
	interface MyInterface {
		void execute();
	}
	
	interface MyHelper {
		int calculate(int args);
	}

	class DefaultMyInterface implements MyInterface {
		//Don't do this. Using setter or constructor injection instead.
		@SuppressWarnings("unused")
		private MyHelper badHelper = new MyHelper() {
			public int calculate(int args) {
				return 0;
			}
		};
		private MyHelper helper;
		public void setMyHelper(MyHelper helper) {
			this.helper = helper;
		}
		
		public void execute() {
			//Do some business logic
			@SuppressWarnings("unused")
			int value = helper.calculate(0);
			//Do more work
		}
	}
}
