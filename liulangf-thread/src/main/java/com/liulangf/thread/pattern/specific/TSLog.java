package com.liulangf.thread.pattern.specific;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-13
 */
public class TSLog {
    private PrintWriter writer = null;

    //  初始化writer字段
    public TSLog(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  加入一笔log
    public void println(String s) {
        writer.println(s);
    }

    //  关闭log
    public void close() {
        writer.println("==== End of log ====");
        writer.close();
    }
}
