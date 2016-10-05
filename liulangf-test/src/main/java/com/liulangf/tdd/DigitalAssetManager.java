package com.liulangf.tdd;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A demo for using JUnit Rule testing.
 * 
 * @author LiuYuQing
 */
public class DigitalAssetManager {
	private final static Logger LOGGER = LoggerFactory.getLogger(DigitalAssetManager.class);
	
	private File assets;
	
	public DigitalAssetManager(File icon, File assets) {
		if (icon == null) {
			throw new IllegalArgumentException("Icon is null, not a file, or doesn't exist.");
		}
		
		if (assets == null) {
			throw new IllegalArgumentException("assets is null, not a folder, or doesn't exist.");
		}
		this.assets = assets;
		
	}
	
	public int getAssetCount() {
		String[] files = assets.list();
		for (String file : files) {
			LOGGER.info("file [{}]", file);
		}
		return files.length;
	}

}
