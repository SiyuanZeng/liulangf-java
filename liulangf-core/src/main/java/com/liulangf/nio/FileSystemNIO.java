package com.liulangf.nio;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * java.nio.file.*;
 * java.nio.file.attribute.*;
 * java.nit.file.spi.*;
 */
public class FileSystemNIO {
	
	
	public void fileSystem() {
		FileSystem fs = FileSystems.getDefault();
		Path path = Paths.get(".");
		path = path.normalize();
		path.forEach(System.out::println);
	}

}
