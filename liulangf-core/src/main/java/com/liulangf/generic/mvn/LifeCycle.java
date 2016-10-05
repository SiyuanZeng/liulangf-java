package com.liulangf.mvn;

/**
 * When you tell Maven to build d project, you are telling Maven to step through a defined sequence of phases
 * and execute any goals which may have been registered with each phase.
 * 
 * There are three standard lifecycles in Maven: clean, default (sometimes called build) and site.
 * <ul>
 *   <li>clean</li>
 *   <li>default:build</li>
 *   <li>site</li>
 * </ul>
 * 
 * 
 * @author LiuYuQing
 * @version 1.0 2010-12-18
 */
public class LifeCycle {
	
	/**
	 * The Clean plugin's clean goal (clean:clean) is bound to the clean phase in the clean lifecycle.
	 * 
	 * pre-clean
	 * clean
	 * post-clean
	 * 
	 * Simply running the clean:clean goal will not execute the lifecycle at all, but specifying the clean phase 
	 * will use the clean lifecycle and advance through the three lifecycle phases until it reaches the clean phase.
	 */
	public void cleanLifeCycle() {
	}
	
	/**
	 * [mvn lifecycle:phase] => mvn process-test-resources
	 * 
	 * validate
	 * generate-sources
	 * process-sources
	 * generate-resources
	 * process-resources
	 * compile
	 * process-classes
	 * generate-test-sources
	 * process-test-sources
	 * generate-test-resources
	 * process-test-resources
	 * test-compile
	 * test
	 * prepare-package
	 * package
	 * pre-integration-test
	 * integration-test
	 * post-integration-test
	 * verify
	 * install
	 * deploy
	 */
	public void mavenBuildLifeCycle() {
	}

	/**
	 * jar
	 * pom
	 * maven plugin
	 * ejb
	 * war
	 * ear
	 */
	void package_specific_lifecycle() {}
	
	
}
