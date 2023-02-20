package com.company;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) throws IOException, ClassNotFoundException {

        this.clientSocket = clientSocket;
        ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
        Person person = (Person) in.readObject();

        //BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
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
                    FlattenPerson flattenPerson = new FlattenPerson();
                    Person person = new Person("Meron", "Stockholm", 27); // Sample person object
                    flattenPerson.serialize(person, "details.ser");


                }
                System.out.println("Message from client: " + request);
            }
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }
}