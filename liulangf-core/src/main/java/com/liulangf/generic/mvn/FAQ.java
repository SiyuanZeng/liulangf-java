package com.liulangf.mvn;

public class FAQ {

	/**
	 * When package war, package webApp class to a jar.
	 * Add <archiveClasses>true</archiveClasses> to war plugin.
	 * 
	 * <plugin>
	 *   <groupId>org.apache.maven.plugins</groupId>
	 *   <artifactId>maven-war-plugin</artifactId>
	 *   <version></version>
	 *   <configuration>
	 *       <archiveClasses>true</archiveClasses>
	 *   </configuration>
	 * </plugin>
	 */
	void packageWar() {
	}

	/**
	 * Each dependency can specify a scope, which controls its visibility and inclusion in the final 
	 * packaged artifact, such as a WAR or EAR. Scoping enables you to minimize the JARs that ship 
	 * with your product.
	 */
	void scope() {
	}

	/**
	 * Maven created an acronym for its plugin classes that aggregates “Plain Old Java Object” and 
	 * “Maven Java Object” into the resultant word, Mojo.
	 * 
	 */
	void mojo() {
	}
	
	/**
	 * 定义主构件的附属构件。如：source，javadoc。
	 */
	void classifier() {
	}
	

}
