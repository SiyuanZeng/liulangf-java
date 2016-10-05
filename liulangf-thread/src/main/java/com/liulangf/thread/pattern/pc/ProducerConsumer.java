package com.liulangf.thread.pattern.pc;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-8
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        Table table = new Table(3);     // 建立可以放置3個蛋糕的桌子
        new Maker("MakerThread-1", table, 31415).start();
        new Maker("MakerThread-2", table, 92653).start();
        new Maker("MakerThread-3", table, 58979).start();
        new Eater("EaterThread-1", table, 32384).start();
        new Eater("EaterThread-2", table, 62643).start();
        new Eater("EaterThread-3", table, 38327).start();
        //new ClearThread("ClearThread-0", table).start();
    }
}
