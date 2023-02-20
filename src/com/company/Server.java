package com.company;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 1234;

    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket client = serverSocket.accept();
            System.out.println("Client connected from " + client.getRemoteSocketAddress().toString());
            ClientHandler clientHandler = new ClientHandler(client);
            clients.add(clientHandler);
            pool.submit(clientHandler);
        }
    }
}