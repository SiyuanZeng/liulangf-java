package com.liulangf.java7;

/**
 * From <<Java 7 In a NutShell>>.
 * Five years in the making...., 147 builds, 4 major JSRs.
 * On track to Java7 GA on July 28, 2011. 
 * 
 * JDK7 Plan B -> JDK 8 to follow with larger features.
 * 
 * Java SE 7 JSRs
 * <ul>
 *   <li>JSR 336: Java SE 7 Release Contents</li>
 *   <li>JSR 203: More New I/O APIs for the Java Platform("NIO.2")</li>
 *   <li>JSR 292: Supporting Dynamically Typed Languages on the Java Platform(invokeddynamic)</li>
 *   <li>JSR 334: Small Enhancements to the Java Programming Language(Project Coin)</li>
 * </ul>
 * 
 * Maintenance:
 * <ul>
 *   <li>JSR 114: JDBC Rowset Implementations</li>
 *   <li>JSR 269: Pluggable Annotation Processing API</li>
 *   <li>JSR 901: Java Language Specification</li>
 *   <li>JSR 924: JVM Specification</li>
 * </ul>
 * 
 * JDK 8 => JSR 337: Java SE 8 Release Contents
 * <ul>
 *   <li>Project Lambda => JSR 335: Lambda Expressions for the Java Programming Language</li>
 *   <li>Project Jigsaw => JSR TBD: Bringing a standard module system to the Java SE platform</li>
 * </ul>
 *
 * @author Quqing Liu
 */
public class NewFeatures {
	String evolution() {
		return "JDK 1.2 -> JDK 1.4 -> JDK 5 -> JDK 6 -> JDK 7!";
	}
	
	class Features {
		/**
		 * First new JVM byte code.
		 * Also planned to be used for Project Lambda implementation in JDK 8
		 */
		void invokedynamic_jsr292() {
		}
		void nio2_jsr203() {}
		void project_coin_language_changes_jsr334(){}
		
		void fork_join_framework() {}
		void jdbc_4_1() {}
		void gervill_sound_engine() {}
		void upgraded_classLoader_architecture() {}
		void elliptic_curve_cryptography_ecc() {}
		void xrender_pipeline_for_java2d() {}
	}

}
