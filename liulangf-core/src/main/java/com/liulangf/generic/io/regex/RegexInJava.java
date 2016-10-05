package com.liulangf.io.regex;

import java.util.regex.Matcher;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * JSR-51
 * java.util.regex
 * 
 * <ul>
 *   <li>A Pattern object is a compiled representation of a regular expression.</li>
 *   <li>A Matcher object is the engine that interprets the pattern and performs match operations against an input string. </li>
 *   <li></li>
 * </ul>
 * 
 * 
 * @author liulangf
 *
 */
public class RegexInJava {
	
	public void setUp() {
		Pattern pattern = Pattern.compile("^helloworld$");
		Matcher matcher = pattern.matcher("helloworld");
		if (matcher.matches()) {
			System.out.println("Good boy!");
		}
		
		matcher.matches();
		matcher.find();
		matcher.start();
		matcher.end();
		matcher.group();
	}

	/**
	 * The metacharacters supported by java.util.regex API are: 
	 *   <([{\^-=$!|]})?*+.>
	 *   
	 *   <>(){}^$?*.+!-=|
	 *   
	 * In certain situations the special characters listed above will not be treated as metacharacters.
	 * There are two ways to force a metacharacter to be treated as an ordinary character:
	 * <ul>
	 *   <li>precede the metacharacter with a backslash, or</li>
	 *   <li>enclose it within \Q (which starts the quote) and \E (which ends it).</li>
	 * </ul> 
	 */
	public void metacharacters() {
//		return "<([{\^-=$!|]})?*+.>";
	}

}
