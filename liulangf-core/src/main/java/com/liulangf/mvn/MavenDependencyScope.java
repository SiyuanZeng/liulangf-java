package com.liulangf.mvn;

/**
 * <dependency>
 *     <groupId>org.apache.httpcomponents</groupId>
 *     <artifactId>fluent-hc</artifactId>
 *     <version>4.2.1</version>
 *     <scope>system</scope>
 *     <systemPath>${basedir}/lib/fluent-hc-4.2.1.jar</systemPath>
 * </dependency>
 */
public class MavenDependencyScope {
	
	enum Scope {
		compile,
		provided,
		runtime,
		test,
		system,
		import_
	}
	

}
