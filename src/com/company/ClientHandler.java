package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) throws IOException {

        this.clientSocket = clientSocket;
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    @Override
    public void run(){
        try {
            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String request = in.readLine();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                if (request.contains("exit")) {
                    out.close();
                    in.close();
                    break;
                } else {
                    out.println(" >>> " + request);
                    System.out.println("Server sent echo!");
                }
                System.out.println("Message from client: " + request);
            }
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }


    }
}