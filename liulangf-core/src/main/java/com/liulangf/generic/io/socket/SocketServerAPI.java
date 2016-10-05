
package com.liulangf.io.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liulangf
 *
 */
public class SocketServerAPI {
    
    public static void main(String... args) throws IOException {
        ServerSocket server = new ServerSocket(8989);
        System.out.println("==server is ok.==");
        server.setSoTimeout(5000);
        Socket socket = server.accept();
        System.out.println("======connection is comming=====");
    }

}
