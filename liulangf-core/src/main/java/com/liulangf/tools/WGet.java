/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.tools;

/**
 * http://users.ugent.be/~bpuype/wget/
 * WGET for Windows (win32) 
 * 
 * @author Quqing Liu
 */
public class WGet {
	
	//Mirror the entire site locally.
	String createMirror() {
		String command = 
			"set http_proxy=http://proxy-bj1.petrochina:8080" +
			"wget --proxy=on " +
			"--mirror" +
			"--html-extension" +
			"--convert-links" +
			" http://www.martinfowler.com";
		
		return command;
	}
	
	/**
	 * 命令行中-w 20代表间隔20秒下载一个文件，这样可以避免网站的访问过于频繁。-m 是镜像
	 * 同时也可以使用其他的一些参数：-c 是继续传送 ， -p 是下载媒体文件，比如图片， -q 是安静模式， -b 是后台运行
	 * 
	 * @return
	 */
	String createMirror2() {
		String command = 
			"wget -mk -w 20 http://www.google.com";
		return command;
	}

}
