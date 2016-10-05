/*************************************************************************
* Copyright (c) 2006-2012 www.liulangf.com
* All Rights Reserved.
*
*************************************************************************/
package com.liulangf.pattern.common;

/**
 * From <<Evolutionary architecture and emergent design-Leveraging reusable code 2>>, Neal Ford.
 * 
 * 
 * @author LiuYuqing
 */
public class CapturingIdiomaticPatterns {
	
	/**
	 * The easiest way to capture idiomatic patterns is to extract them as their own API or framework.
	 * Most of the open source frameworks you use are sets of related idiomatic patterns that have to do
	 * with solving a particular problem.
	 */
	void havesting_patterns_as_apis() {
	}
	
	class AvoidingStructualDuplication {
		
		class Car {
			public void setDescription(Description desc) {}
		}
		
		class Description {
			public void setType(String type) {}
			public void setSubType(String subType) {}
			public void setAttribute(String key, Object value) {}
		}
		
		void structuralDuplication() {
			Car car = new Car();
			Description desc = new Description();
			desc.setType("Box");
			desc.setSubType("Insulated");
			desc.setAttribute("length", "50.5");
			desc.setAttribute("ladder", "yes");
			//Forcing the user to type the host object(desc) adds
			//needless noise to the code.
			car.setDescription(desc);
		}
		
		/**
		 * One uses a little-known java syntax that allows you to "carry" a host
		 * object via the scoping of an anonymous inner class.
		 * 
		 * We can also call this functional sequence - Uses inheritance and anonymous inner 
		 * classes to create a context wrapper.
		 * 
		 * The syntax looks odd because of the double {{ braces. The first set of enclosing braces 
		 * delineates the construction of an anonymous inner class, and the second set delineates the
		 * instance initializer for the anonymous inner class.
		 * 
		 * The only thing a class needs to be used this way is a default constructor 
		 * (which allows you to create an anonymous inner class instance inheriting from your class ). 
		 * => Fluent Interface.
		 */
		void carry_a_host_object() {
			Car car = new Car();
			car.setDescription(new Description() {{
				setType("Box");
				setSubType("Insulated");
				setAttribute("length", "50.5");
				setAttribute("ladder", "yes");
			}});
			
			//This is so cool.
			Car car2 = new Car() {
				{
					setDescription(new Description() {
						{
							setType("Box");
							setSubType("Insulated");
							setAttribute("length", "50.5");
							setAttribute("ladder", "yes");			
						}
					});
				}
			};
		}
	}

}
