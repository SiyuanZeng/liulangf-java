package com.liulangf.ant;

/**
 * <p>
 * To pass data to tasks, you need to be able to construct and refer to datatypes and properties in a build file. 
 * As with tasks, datatypes are just pieces of XML, pieces that list files or other resources that a task can use.
 * 
 * <p>
 * The datatypes act as parameters to tasks. You can declare them inside a task or define them outside, 
 * give them a name, and then pass that name to a task.
 * 
 * type elements:
 * <ul>
 *   <li>path</li>
 *   <li>fileset</li>
 *   <li>classpath</li>
 * </ul>
 * 
 *
 */
public class Ant_Datatypes_Properties {
    
    /**
     * <p>
     * Every Ant datatype declaration can have a unique identifier, which can be used as a reference.
     * <fileset id="source.fileset" dir="src" includes="*.java" />
     * 
     * <fileset refid="source.fileset"/>
     */
    void reference_with_refid() {
    }

    /**
     * <path id="lib.path"> 
     *     <!-- location is single element-->
     *     <pathelement location="lib/junit.jar"/> 
     *     <pathelement path="build/classes;lib/junit.jar"/>
     *     
     *     <fileset dir="lib">
     *         <include name="*.jar"/>
     *     </fileset>
     * </path>
     * 
     */
    void path_like_structure() {
    }
    
    /**
     * Build-in properties:
     * <ul>
     *   <li>basedir</li>
     *   <li>ant.file</li>
     *   <li>ant.version</li>
     *   <li>ant.project.name</li>
     *   <li>ant.project.default-target</li>
     *   <li>ant.home</li>
     *   <li>ant.core.lib</li>
     *   <li>ant.java.version</li>
     *   <li>ant.library.dir</li>
     * </ul>
     *
     * <p>
     * Using property task.
     * 
     * Setting a property to a filename
     * <property name="release.dir" location="../../release"/>
     * <p>
     * loading from a properties file
     * <property file="build.properties"/>
     * <p>
     * system env
     * <property environment="evn"/>
     */
    void properties() {
    }

}
