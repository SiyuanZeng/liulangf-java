package com.liulangf.io.channel;

/**
 * Many operating systems can make the assembly/disassembly process even more efficient. 
 * The notion of scatter/gather allows a process to pass a list of buffer addresses to the 
 * operating system in one system call. The kernel can then fill or drain the multiple buffers 
 * in sequence, scattering the data to multiple user space buffers on a read, or gathering from 
 * several buffers on a write.
 * 
 * Scatter/gather should be used with direct ByteBuffers to gain the greatest advantage from native I/O, 
 * especially if the buffers are long-lived.
 */
public class ScatterAndGather {

}
