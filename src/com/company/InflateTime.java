package com.company;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
class InflateTime {
    public Person deserialize(String filename){
        Person person = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            person = (Person)in.readObject();
            in.close();
        } catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return person;
    }
}