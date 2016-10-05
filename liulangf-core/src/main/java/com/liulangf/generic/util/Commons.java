package com.liulangf.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * @author LiuYuQing
 * @version 1.0 2010-6-12
 */
public class Commons {
	
	public static void main(String...args) {
		System.out.println("Begin..");//e:\temp\wentai_thrkd\jsp\
		//deleteCVS("e:\\temp\\wentai_thrkd");f:\work\cnpc\esb-talimu\
		//String root = "f:\\temp\\eBus-server-3.0";
		String root = "f:\\temp\\ebus\\server";
		//f:\temp\ebus-server-1.8\
		//String root = "k:\\store\\soa\\esb\\apache-serviceMix\\servicemix-extensions";
		//deleteSVN(root);
		deleteCVS("h:\\work\\kongzhong\\");
		System.out.println("Done!");
	}
	
	
	public static void badCast(Object obj) {
        // must do this ugly cast to avoid compiler error on AIX/HP-UX
		Object temp = (Object) obj;
        //ProcessorDefinition defn = (ProcessorDefinition) this;
	}
	
	public static void deleteSVN(String root) {
		deleteSVN(new File(root));
	}
	
	public static void deleteCVS(String root) {
		deleteCVS(new File(root));
	}
	
	public static void deleteCVS(File cvsroot) {
		if (cvsroot.isDirectory()) {
			doDelete(cvsroot);			
			File[] all = cvsroot.listFiles();
			for (File f : all) {
				if (f.isDirectory()) {
					deleteCVS(f);
				}
			}
		}
	}
	
	private static void doDelete(File cvsroot) {
		File cvs = new File(cvsroot, "CVS");	
		if (cvs.isDirectory()) {
			File[] cvss = cvs.listFiles();
			for (File f : cvss) {
				f.delete();
			}
			cvs.delete();
		}
	}
	
	public static void deleteSVN(File svnroot) {
		if (svnroot.isDirectory()) {
			doDeleteSVN(svnroot);			
			File[] all = svnroot.listFiles();
			for (File f : all) {
				if (f.isDirectory()) {
					deleteSVN(f);
				}
			}
		}
	}
	
	
	private static void doDeleteSVN(File svnroot) {
		File svn = new File(svnroot, ".svn");
		try {
			System.out.println("==delete svn[" + svn.getAbsolutePath() + "]");
			FileUtils.deleteDirectory(svn);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
