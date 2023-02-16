package com.company;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class InflateTime {
    public static void main(String [] args){
        String filename = "details.ser";
        if(args.length > 0) {
            filename = args[0];
        }
        Peron time = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            time = (Peron)in.readObject();
            in.close();
        } catch(IOException ex){
            ex.printStackTrace();
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
// print out restored time
        assert time != null;
        System.out.println("Details: " + time.getDetails());
        System.out.println();
    }
}