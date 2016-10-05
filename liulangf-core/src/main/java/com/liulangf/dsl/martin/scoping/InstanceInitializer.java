/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.dsl.martin.scoping;

/**
 * A way to use Object Scoping in a relatively unobtrusive inline manner is to use an instance initializer. 
 * This technique was popularized by JMock; I confess that until I'd seen it used, I completely neglected 
 * that language feature.
 * 
 * The trick is the use of double curly brackets in the DSL script. This creates not an instance of the zone builder, 
 * but an inner class that's an instance of a subclass of the zone builder. This one-off subclass has the code between 
 * the double curly braces woven into the constructor. You can always do this sort of thing in Java, although I've not 
 * seen it that widely used. Since the code between the double curlies is in a subclass of zone builder, we have the 
 * Object Scoping that we need.
 * 
 * @author Quqing Liu
 */
public class InstanceInitializer {
	
	
	void it_is_so_cool() {
		ZoneBuilder builder = new ZoneBuilder() {{
		  //instance initialize block
			allow(department(""));
			refuse(department(""));
			refuse(department(""));
			allow(
				gradeAtLeast(""),
				department("")
			);
		}};
		builder.getValue();
		
	}

}
