package com.company;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FlattenPerson {
    public static void main(String [] args){
        String filename = "details.ser";
        if(args.length > 0){
            filename = args[0];
        }
        Person time = new Person("Meron", "Stockholm", 27);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(time);
            out.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public void serialize(Person person, String filename){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(person);
            out.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

}