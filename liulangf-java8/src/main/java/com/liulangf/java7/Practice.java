package com.liulangf.java7;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Practice {
	private static final transient Logger LOGGER = LoggerFactory.getLogger(Practice.class);
	
	public String stringSwitch(String day) {
		switch (day) {
		    case "MON" : return "Monday";
		    case "TUE" : return "Tuesday";
		    case "WED" : return "Wednesday";
		    case "THU" : return "Thurday";
		    case "FRI" : return "Friday";
		    case "SAT" : return "Saturday";
		    default : return "Sunday";
		}
	}
	
	public List<String> improvedTypeInterface() {
		return new ArrayList<>();
	}
	
	public void numberLiterial() {
		int x = 0B1100110;
		long y = 2_147_483_648L;
		int z = 0b0001_1100_0011_0111_0010;
		
		LOGGER.info("{}, {}, {}", new Object[]{x, y, z});
	}

	public static void main(String...args) {
		new Practice().numberLiterial();
	}


}
