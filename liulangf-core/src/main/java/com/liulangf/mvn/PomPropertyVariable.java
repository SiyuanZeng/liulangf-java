package com.liulangf.mvn;

/**
 * A wide range of predefined or custom of property variables can be used anywhere in your 
 * pom.xml files to keep string and path repetition to a minimum. 
 * All properties in Maven begin with ${ and end with }.
 * 
 * @author liulangf
 *
 */
public class PomPropertyVariable {
	
	public String listAllAvailableProperties() {
		return "mvn help:expressions";
	}
	
	public String note() {
		return "In Maven 3.0, all pom.* properties are deprecated. Use project.* instead!";
	}
	
	/**
	 * There some implicit properties available in any Maven project, these implicit properties are:
	 * <ul>
	 *   <li>project.* - You can use the project.* prefix to reference values in a Maven POM.</li>
	 *   <li>settings.* - You use the settings.* prefix to reference values from your Maven Settings in ~/.m2/settings.xml.</li>
	 *   <li>env.* -Environment variables like PATH and M2_HOME can be referenced using the env.* prefix.</li>
	 *   <li>System Properties - Any property which can be retrieved from the System.getProperty() method can be referenced as a Maven property.</li>
	 * </ul>
	 * 
	 */
	public void implicitProperties() {
	}
	
	public void resourceFilting() {
	}
	
	/**
	 * http://maven.apache.org/maven-1.x/reference/properties.html
	 */
	public void buitInProperties() {
		
	}

}
