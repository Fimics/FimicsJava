package com.mic.thread.design.twophase;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppServer extends Thread{

    private final int port;
    private static final int DEFAULT_PORT =12222;

    private volatile boolean start = true;

    private List<ClientHandler> threadList = new ArrayList<>();

    private final  ExecutorService executor = Executors.newFixedThreadPool(10);

    private ServerSocket serverSocket;


    public AppServer(){
        this(DEFAULT_PORT);
    }

    public AppServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            while (start){
                Socket socket =serverSocket.accept();
                ClientHandler clientRunnable = new ClientHandler(socket);
                executor.submit(clientRunnable);
                this.threadList.add(clientRunnable);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            this.dispose();
        }

    }

    private void dispose() {
        System.out.println("dispose");
        threadList.stream().forEach(clientHandler -> clientHandler.stop());
        this.executor.shutdown();
    }


    public void shutdown() throws IOException {
        this.start=false;
        this.interrupt();
        this.serverSocket.close();

    }
}
