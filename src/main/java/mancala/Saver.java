package mancala;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Saver {

    
    public static void saveObject(final Serializable toSave, final String filename){
        try{
            final ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("assets/"+filename));
            out.writeObject(toSave);
            out.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    public static Serializable loadObject(final String filename){
        Serializable loaded = null;
        try{
            final ObjectInputStream input = new ObjectInputStream(new FileInputStream("assets/"+filename));
            loaded = (Serializable)input.readObject();
            input.close();
        } catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return loaded;
    }
}