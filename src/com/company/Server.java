package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final Integer PORT = 1234;

    public static void main(String[] args) {
        new Server().runServer();
    }

    private void runServer() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + PORT);
            System.exit(-1);
        }

        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection accepted to: " + clientSocket.getInetAddress());
                new Thread(() -> { // multi - connection server
                    try {
                        ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                        Object inputObj;
                        while ((inputObj = in.readObject()) != null) {
                            Person person = (Person) inputObj;
                            System.out.println("Received person object: " + person.getDetails());
                        }
                        in.close();
                        clientSocket.close();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                        System.err.println("Failed in reading, writing");
                        System.exit(-1);
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
