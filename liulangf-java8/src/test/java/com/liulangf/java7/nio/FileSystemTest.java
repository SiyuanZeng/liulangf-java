package com.liulangf.java7.nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileSystemTest {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	public void basicTest() {
		long gigabyte = 1_073_741_824L;
		FileSystem fs = FileSystems.getDefault();
		fs.getFileStores().forEach(f -> {
			try {
				System.out.format("\nStore: %-20s %-5s Capacity: %5dgb Unallocated: %6dgb", 
						f.name(),
						f.type(),
						f.getTotalSpace()/gigabyte,
						f.getUnallocatedSpace()/gigabyte);
			} catch (Exception e) {
			}
		});
	}


	@Test
	public void pathTest() {
		Path a = Paths.get("a.txt");
		Path b = Paths.get("dir", "b.txt");
		Path c = Paths.get(System.getProperty("user.home"), "c.txt");
	}
	
	@Test
	public void writeTest() throws IOException {
		Path a = Paths.get("a.txt");
		if (!Files.exists(a)) {
			Files.createFile(a);
		}
		BufferedWriter w = Files.newBufferedWriter(a, StandardOpenOption.WRITE);
		w.write("Just a test");
		w.flush();
		w.close();
	}
	
}
