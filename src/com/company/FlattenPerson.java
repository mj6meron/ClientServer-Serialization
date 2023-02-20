package com.company;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class FlattenPerson {
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