package com.liulangf.io.channel;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelCopy {

	public void channelCopy(ReadableByteChannel src, WritableByteChannel dest)
			throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(16 * 1024);
		while (src.read(buffer) != -1) {
			// prepare the buffer to be drained
			buffer.flip();

			// make sure the buffer was fully drained.
			while (buffer.hasRemaining()) {
				dest.write(buffer);
			}

			// make the buffer empty, ready for filling
			buffer.clear();
		}
	}

	public void channelCopy2(ReadableByteChannel src, WritableByteChannel dest)
			throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(16 * 1024);
		while (src.read(buffer) != -1) {
			// prepare the buffer to be drained
			buffer.flip();

			// write to the channel, may block
			dest.write(buffer);

			// if partial transfer, shift remaining elements down
			// if buffer was empty, same as doing clear
			buffer.compact();
		}

		buffer.flip(); // EOF leaves buffer in fill state

		while (buffer.hasRemaining()) {
			dest.write(buffer);
		}
	}

	public void channelCopy3(FileChannel src, WritableByteChannel dest)
			throws IOException {
		src.transferTo(0, src.size(), dest);
	}

	public void channelCopy4(ReadableByteChannel src, FileChannel dest)
			throws IOException {
		dest.transferFrom(src, 0, Long.MAX_VALUE);
	}
	
	
    private static void nioTransferCopy(File source, File target) {
        FileChannel in = null;
        FileChannel out = null;

        FileInputStream inStream = null;
        FileOutputStream outStream = null;

        try {
            inStream = new FileInputStream(source);
            outStream = new FileOutputStream(target);

            in = inStream.getChannel();
            out = outStream.getChannel();

            in.transferTo(0, in.size(), out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(inStream);
            close(in);
            close(outStream);
            close(out);
        }
    }

    private static void close(Closeable closable) {
        if (closable != null) {
            try {
                closable.close();
            } catch (IOException e) {
            }
        }
    }
}
