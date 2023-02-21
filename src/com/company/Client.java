package com.company;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        InetAddress HOST = null;
        final int serverPort = 1234;
        ObjectOutputStream out = null;
        try {
            String c = "192.168.0.102";

            // Connect to server
            Socket socket = new Socket(InetAddress.getByName(c), serverPort);
            assert false;
            System.out.println("Connected to " + HOST.getHostName() + ":" + serverPort);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O");
            System.exit(1);
        }
        System.out.println("Generate a random person object? y/n?");
        System.out.print(">");
        Scanner scanner = new Scanner(System.in);

        String userInput;
        try{
            while ((userInput = scanner.nextLine()) != null) {
                Person person = generateRandomPerson();
                System.out.println(person.getDetails());
                out.writeObject(person);
                if (userInput.equals("n"))
                    break;
                System.out.print(">");
            }
            out.close();
            socket.close();
        }catch (IOException ioe) {
            System.out.println("Failed");
            System.exit(-1);
        }
    }

    public static Person generateRandomPerson() {
        String[] names = {"Alex", "John", "Jane", "Jim", "Sarah", "Emma", "Michael", "Emilie", "Olivia", "William"};
        String[] addresses = {"Stockholm", "London", "New York", "Sydney", "Paris", "Berlin", "Tokyo", "Moscow", "Toronto", "Dubai"};
        int nameIndex = (int) (Math.random() * names.length);
        int addrIndex = (int) (Math.random() * addresses.length);
        int age = (int) (Math.random() * 100);
        return new Person(names[nameIndex], addresses[addrIndex], age);
    }
}