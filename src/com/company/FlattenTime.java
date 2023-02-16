package com.company;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FlattenTime {
    public static void main(String [] args){
        String filename = "details.ser";
        if(args.length > 0){
            filename = args[0];
        }
        Peron time = new Peron("Meron", "Stockholm", 27);
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
    }}