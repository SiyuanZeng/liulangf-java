package com.liulangf.resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ResourceSmartLoader {
	
	public void loadResourceWithSpringResource() throws IOException {
		Resource resource = new ClassPathResource("hello-bean.xml");
		File file = resource.getFile();
		InputStream in = resource.getInputStream();
	}

}
