/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.mvn;

/**
 * Maven plugins and usage:
 * http://maven.apache.org/plugins/index.html
 * http://maven.apache.org/guides/mini/guide-configuring-plugins.html
 * 
 * @author YuQing Liu
 *
 */
public class GoodPlugins {
	

	/**
	 * http://mojo.codehaus.org/build-helper-maven-plugin/
	 * This plugin contains various small independent goals to assist with the Maven build lifecycle.
	 * 
	 */
	void build_helper_maven_plugin() {
		
	}

	/**
	 * m2eclipse http://m2eclipse.sonatype.org/sites/m2e
	 */
	void mavenEclipsePlugin() {
	}
	
	/**
	 * http://checkstyle.sourceforge.net/
	 * The Checkstyle Plugin generates a report regarding the code style used by the developers. 
	 * 
	 * <reporting>
	 *    <plugins>
     *       <plugin>
     *           <groupId>org.apache.maven.plugins</groupId>
     *           <artifactId>maven-checkstyle-plugin</artifactId>
     *           <version>2.7</version>
     *           <configuration>
     *               <configLocation>http://221.179.172.87/common_checks.xml</configLocation>
     *               <includeTestSourceDirectory>false</includeTestSourceDirectory>
     *           </configuration>
     *       </plugin>
     *    </plugins>
	 * </reporting>
	 * 
	 * Usage:
	 *   mvn checkstyle:checkstyle
	 *   mvn checkstyle:check
	 */
	void checkstyle() {}
	
	/**
	 * Report test coverage.
	 *  
	 * <reporting>
	 *    <plugins>
     *       <plugin>
     *           <groupId>org.codehaus.mojo</groupId>
     *           <artifactId>cobertura-maven-plugin</artifactId>
     *           <version>2.3</version>
     *       </plugin>
     *    </plugins>
	 * </reporting>
	 * 
	 * Usage:
	 * 
	 *     cobertura:check Check the Last Instrumentation Results.
	 *     cobertura:clean Clean up rogue files that cobertura maven plugin is tracking.
	 *     cobertura:dump-datafile Cobertura Datafile Dump Mojo.
	 *     cobertura:instrument Instrument the compiled classes.
	 *     cobertura:cobertura Instruments, Tests, and Generates a Cobertura Report
	 * 
	 */
	void cobertura() {}
	
	/**
	 * http://findbugs.sourceforge.net/
	 * http://mojo.codehaus.org/findbugs-maven-plugin/
	 * 
	 * FindBugs looks for bugs in Java programs. It is based on the concept of bug patterns.
	 * A bug pattern is a code idiom that is often an error.
	 * 
	 * FindBugs uses static analysis to inspect Java bytecode for occurrences of bug patterns.
	 * FindBugs uses BCEL to analyze Java bytecode. It uses dom4j for XML manipulation.
	 * 
	 * <reporting>
	 *    <plugins>
     *       <plugin>
     *           <groupId>org.codehaus.mojo</groupId>
     *           <artifactId>findbugs-maven-plugin</artifactId>
     *           <version>2.3.2</version>
     *       </plugin>
     *    </plugins>
	 * </reporting>
	 * 
	 * Usage:
	 *   mvn site
	 *   mvn findbugs:findbugs Generates a Findbugs Report;
	 *   mvn findbugs:gui Launch the Findbugs Gui to display the FindBugs report.
	 */
	void findBugs() {}
	
	/**
	 * http://pmd.sourceforge.net/
	 * 
     * <reporting>
     *   <plugins>
     *     <plugin>
     *       <groupId>org.apache.maven.plugins</groupId>
     *       <artifactId>maven-pmd-plugin</artifactId>
     *       <version>2.5</version>
     *     </plugin>
     *   </plugins>
     * </reporting>
	 */
	void pmd() {}
	
	/**
	 * http://mojo.codehaus.org/javancss-maven-plugin/
	 * JavaNCSS is a source measurement suite for Java which produces quantity & complexity metrics for your java source code.
	 * 
	 * Maven2 plugin generating NCSS and CCN code metrics.
	 * 
	 * <ul>
	 *   <li>Non Commenting Source Statements (NCSS).</li>
	 *   <li>Cyclomatic Complexity Number (McCabe metric).</li>
	 *   <li>Packages, classes, functions and inner classes are counted.</li>
	 * </ul>
	 * 
	 * <reporting>
	 *   <plugins>
	 *     <plugin>
	 *       <groupId>org.codehaus.mojo</groupId>
	 *       <artifactId>javancss-maven-plugin</artifactId>
	 *       <version>2.0-beta-2</version>
	 *     </plugin>
	 *   </plugins>
	 * </reporting>
	 * 
	 * Usage:
	 *   mvn site or
	 *   mvn javancss:report -> Generates a report of quantity and complexity metric on your code.
	 *   mvn javancss:check -> Check if your source code has a CCN or NCSS value too high, fails the build if so.
	 */
	void javaNCSS() { }
	
	/**
	 * http://code.google.com/p/maven-overview-plugin/
	 * A simple Maven plugin, creating a diagram of all dependencies.
	 * 
	 * <reporting>
	 *   <plugins>
	 *     <plugin>
	 *       <groupId>com.googlecode.maven-overview-plugin</groupId>
	 *       <artifactId>maven-overview-plugin</artifactId>
	 *       <version>RELEASE</version>
	 *     </plugin>
	 *   </plugins>
	 * </reporting>
	 * 
	 * Usage:
	 *     mvn com.googlecode.maven-overview-plugin:maven-overview-plugin:RELEASE:overview
	 */
	void overView() {}
	
	/**
	 * The Maven Assembly plugin is a plugin you can use to create arbitrary distributions for your applications. 
	 * You can use the Maven Assembly plugin to assemble the output of your project in any format you desire by 
	 * defining a custom assembly descriptor.
	 * 
	 * <plugin>
	 *   <artifactId>maven-assembly-plugin</artifactId>
	 *   <configuration>
	 *     <descriptorRefs>
	 *       <descriptorRef>jar-with-dependencies</descriptorRef>
	 *     </descriptorRefs>
	 *   </configuration>
	 * </plugin>
	 * 
	 * mvn assembly:assembly
	 */
	void assembly() {}
	
	/**
	 * http://mojo.codehaus.org/versions-maven-plugin/version-rules.html
	 * 
	 */
	void versionNumberPlugin() {}
	
	/**
	 * http://mojo.codehaus.org/jaxb2-maven-plugin/
	 */
	void jaxbMavenPlugin() {}
	
	
	/**
	 * http://maven.apache.org/plugins/maven-site-plugin/
	 * 
	 * The APT format, "Almost Plain Text", is a wiki-like format that allows you to write simple, 
	 * structured documents very quickly. 
	 * 
	 * http://maven.apache.org/doxia/references/apt-format.html
	 * http://maven.apache.org/doxia/
	 * 
	 * Maven会使用称为Doxia一个文件处理引擎，它会读取多个源格式转换为通用文档模型的文档。
	 * <ul>
	 *   <li>APT: A Plain Text document format</li>
	 *   <li>XDoc: A Maven 1.x document format</li>
	 *   <li>FML: Used for FAQ documents</li>
	 *   <li>XHtml: Extensible HTML</li>
	 * </ul>
	 * 
	 * 
	 * +- src/
   +- site/
      +- apt/
      |  +- index.apt
      |
      +- xdoc/
      |  +- other.xml
      |
      +- fml/
      |  +- general.fml
      |  +- faq.fml
      |
      +- site.xml
	 */
	void maven_site_plugin() {
		String apt = "";
	}
	
}
