package com.liulangf.mvn;

/**
 * <ul>
 *   <li>Maven plugins and goals</li>
 *   <li>Maven lifecycle</li>
 *   <li>Maven coordinates</li>
 *   <li>Maven repositories</li>
 *   <li>Maven's dependency management</li>
 *   <li>Site generation and reporting</li>
 * </ul>
 * 
 * @author liulangf
 *
 */
public class MavenCoreConcept {
	
	/**
	 * [mvn command syntax] => mvn compile:compile === mvn plugin:goal
	 * 
	 * To execute a single Maven plugin goal, we used the syntax mvn archetype:create, where archetype is the 
	 * identifier of a plugin and create is the identifier of a goal.
	 * 
	 * A Maven Plugin is a collection of one or more goals.
	 * A goal is a specific task that may be executed as a standalone goal or along with other goals as part of 
	 * a larger build. A goal is a “unit of work” in Maven. Goals are configured via configuration properties 
	 * that can be used to customize behavior.
	 */
	void plugin_goal() {}
	
	/**
	 * [mvn command syntax] => mvn install === mvn lifecycle::phase
	 * A phase is a step in what Maven calls the “build lifecycle.” The build lifecycle is an ordered sequence of 
	 * phases involved in building a project. 
	 * 
	 * Plugin goals can be attached to a lifecycle phase. As Maven moves through the phases in a lifecycle, 
	 * it will execute the goals attached to each particular phase. Each phase may have zero or more goals bound to it.
	 */
	void lifeCycle() {}
	
	/**
	 * The POM names the project, provides a set of unique identifiers (coordinates) for a project, and defines the 
	 * relationships between this project and others through dependencies, parents, and prerequisites.
	 * 
	 * Maven Coordinates define a set of identifiers which can be used to uniquely identify a project, a dependency, 
	 * or a plugin in a Maven POM.
	 * 
	 * [coordinate] => [groupId, artifactId, version, packaging, classifier]
	 */
	void coordinate() {}
	
	/**
	 * The standard for a Maven repository is to store an artifact in the following directory relative to the root 
	 * of the repository:
	 *   /<groupId>/<artifactId>/<version>/<artifactId>-<version>.<packaging>
	 * 
	 */
	void repository() {}
	
	/**
	 * Another important feature of Maven is its ability to generate documentation and reports.
	 * mvn site => 
	 * This will execute the site lifecycle phase. Unlike the default build lifecycle that manages generation of code, 
	 * manipulation of resources, compilation, packaging, etc., this lifecycle is concerned solely with processing site 
	 * content under the src/site directories and generating reports.
	 * 
	 */
	void site_report() {}

}
