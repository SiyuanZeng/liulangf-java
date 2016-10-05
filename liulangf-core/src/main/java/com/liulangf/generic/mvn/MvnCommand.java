package com.liulangf.mvn;

/**
 * mvn <phase goal>
 * 
 * mvn -versiong
 * mvn -Dmaven.test.skip=true
 * mvn test -Dmaven.test.failure.ignore=true
 * mvn compile war:exploded
 * mvn test -Dtest=HelloWorld
 *
 * @author Quqing Liu
 */
public class MvnCommand {
	
	
	public String ignoreTestFailure() {
		return "mvn test -Dmaven.test.failure.ignore=true";
	}
	
	public String[] offline() {
		return new String[] {
			"mvn dependency:go-offline",
			"mvn <phase goal> -o"
		};
	}

	public String superPom() {
		return "mvn help:effective-pom";
	}
	
	public String[] archetypeCreate() {
		return new String[] {
			"mvn archetype:create -DgroupId=com.cnpc.richfit -DartifactId=hello",
			"mvn archetype:create -DgroupId=com -DartifactId=x -DarchetypeArtifactId=maven-archetype-webapp"
		};
	}
	
	public String[] archetypeGenerate() {
		return new String[] {
			"mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp -DgroupId=com.cnpc.richfit.helloworkd -DartifactId=hello-web",
		};
	}
	
	/**
	 * mvn eclipse:eclipse
	 * mvn eclipse:clean
	 * @return
	 */
	public String eclipse() {
		return "mvn org.apache.maven.plugins:maven-eclipse-plugin:2.9:eclipse";
	}
	
	public String mvn_install() {
		return "mvn install:install-file "
		    + "-Dfile=f:\\store\\java\\javaee\\servlet3\\javax.servlet-3.0.jar "
			+ "-DgroupId=javax.servlet"
		    + "-DartifactId=javax.servlet "
		    + "-Dversion=3.0 " 
		    + "-Dpackaging=jar "
		    + "-DgeneratePom=true";
	}
	
	public String runningASingleTest() {
		return "mvn -Dtest=TestA,TestB,TestCamel* test";
	}
	
	public String executeMain() {
		return "mvn compile exec:java -Dexec.mainClass=com.liulangf.mvn.MvnCommand";
	}
	
	/**
	 * This will list all of the goals that are available in the Maven Exec plugin. 
	 * @return
	 */
	public String mvn_help() {
		return "mvn help:describe -Dplugin=exec -Dmojo=system -Dfull";
	}
	
	/**
	 * http://maven.apache.org/plugins/maven-dependency-plugin/
	 * Print out a list of resolved dependencies.
	 * @return
	 */
	public String dependency_resolve() {
		return "mvn help:describe -Dplugin=dependency -Dfull" +
			   "mvn dependency:resolve -DincludeScope=compile" +
	           "mvn dependency:help" + 
	           "mvn dependency:copy-dependencies -DincludeScope=compile" +
	           "mvn dependency:copy-dependencies -Dmdep.useRepositoryLayout=true" +
	           "mvn dependency:sources" +
	           "mvn dependency:build-classpath" + 
			   "mvn dependency:tree" ;
	}

	/**
	 * To find out the dependencies of the jetty-servlet module:
	 * @return
	 */
	public String dependency_tree() {
		return "mvn -f jetty-servlet/pom.xml dependency:tree";
	}
}
