package com.liulangf.thread.pattern.per;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-9
 */
public class MiniServer {
    private final int portnumber;
    public MiniServer(int portnumber) {
        this.portnumber = portnumber;
    }
    public void execute() throws IOException {
        ServerSocket serverSocket = new ServerSocket(portnumber);
        System.out.println("Listening on " + serverSocket);
        try {
            while (true) {
                System.out.println("Accepting...");
                final Socket clientSocket = serverSocket.accept();
                System.out.println("Connected to " + clientSocket);
                new Thread() {
                    public void run() {
                        try {
                            Service.service(clientSocket);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
    
    public static void main(String args[]) {
        try {
            new MiniServer(8888).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}