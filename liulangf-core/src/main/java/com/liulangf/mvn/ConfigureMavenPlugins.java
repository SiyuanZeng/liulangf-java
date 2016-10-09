package com.liulangf.mvn;

/**
 * http://maven.apache.org/guides/mini/guide-configuring-plugins.html
 * 
 * In Maven, there are the build and the reporting plugins:
 * <ul>
 *   <li>Build plugins will be executed during the build and then, they should be configured in the <build/> element.</li>
 *   <li>Reporting plugins will be executed during the site generation and they should be configured in the <reporting/> element.</li>
 * </ul>
 * All plugins should have minimal required informations: groupId, artifactId and version.
 * 
 * Important Note: 
 *   It is recommended to always defined each version of the plugins used by the build to guarantee the build 
 *   reproducibility. A good practice is to specify them in the <build><pluginManagement/></build> elements for 
 *   each build plugins (generally, you will define a <pluginManagement/> element in a parent POM). 
 *   For reporting plugins, you should specify each version in the <reporting><plugins/></reporting> elements 
 *   (and surely in the <build><pluginManagement/></build> elements too).
 * 
 * 
 * @author YuQing Liu
 *
 */
public class ConfigureMavenPlugins {
	
	/**
	 * Maven plugins (build and reporting) are configured by specifying a <configuration/> element where the 
	 * child elements of the <configuration/> element are mapped to fields, or setters, inside your Mojo 
	 * (remember that a plug-in consists of one or more Mojos where a Mojo maps to a goal).
	 * <configuration>
	 *   
	 * </configuration>
	 */
	void configuration() {}
	
	/**
	 * Configuring Build Plugins: using the <executions/> tag.
	 * <build>
	 *   <plugins>
	 *     <plugin>
	 *       <executions>
	 *         <execution>
	 *           <id>execution1</id>
	 *           <phase>test</phase>
	 *           <configuration>
	 *           </configuration>
	 *           <goals>
	 *             <goal>query</goal>
	 *           </goals>
	 *         </execution>
	 *         <execution>....</execution> 
	 *       </executions>
	 *     </plugin>
	 *   </plugins>
	 * </build>
	 * 
	 * pluginManagement: is an element that is seen along side plugins. Plugin Management contains plugin elements 
	 * in much the same way, except that rather than configuring plugin information for this particular project build, 
	 * it is intended to configure project builds that inherit from this one.
	 */
	void executions() {}
	
	/**
	 * You can configure a reporting plugin using the <reportSets> tag. 
	 * This is most commonly used to generate reports selectively when running mvn site.
	 * 
	 * <reporting>
	 *   <plugins>
	 *     <plugin>
	 *       <groupId>org.apache.maven.plugins</groupId>
	 *       <artifactId>maven-project-info-reports-plugin</artifactId>
	 *       <version>2.1.2</version>
	 *       <reportSets>
	 *         <reportSet>
	 *           <reports>
	 *             <report>scm</report>
	 *             <report>issue-tracking</report>
	 *             <report>cim</report>
	 *             <report>dependencies</report>
	 *             <report>project-team</report>
	 *           </reports>
	 *         </reportSet>
	 *       </reportSets>
	 *     </plugin>
	 *   </plugins>
	 * </reporting>
	 *  
	 */
	void reportSets() {}

}
