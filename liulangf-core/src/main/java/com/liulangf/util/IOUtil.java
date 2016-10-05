package com.liulangf.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class IOUtil {
	
	private IOUtil() {}
	
	public static byte[] getBytes(InputStream input) throws IOException {
		try {
			byte[] buffer = new byte[4096];
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			for (int count = input.read(buffer); count >= 0; count = input.read(buffer)) {
				output.write(buffer, 0, count);
			}
			byte[] outputs = output.toByteArray();
			return outputs;
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}

}
