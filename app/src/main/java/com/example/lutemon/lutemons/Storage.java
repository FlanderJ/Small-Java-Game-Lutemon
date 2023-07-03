package com.example.lutemon.lutemons;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {
    protected String name;
    protected ArrayList<Lutemon> lutemons = new ArrayList<>();

    Context context;

    // Make Storage a Singleton:
    private  static Storage storage = null;
    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }
    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public Lutemon getLutemonById(int Id) {
        int i = 0;
        for (Lutemon lutemon : lutemons) {
            if (lutemon.getId() == Id) {
                return lutemon;
            }
        }
        return null;
    }

    // Method to initialize context in MainActivity:
    public void init(Context context) {
        this.context = context.getApplicationContext();
        Toast.makeText(context, context.getFilesDir().toString(), Toast.LENGTH_LONG).show();
    }

    // Save Lutemons into file:
    public void saveLutemon(Lutemon lutemon) {
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("lutemons.data", Context.MODE_PRIVATE));
            userWriter.writeObject(lutemons);
            userWriter.close();
        } catch (IOException e){
            System.out.println("Lutemonin tallentaminen epäonnistui");
        }
    }

    // Load saved Lutemons from file:
    public void loadLutemons() {
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("lutemons.data"));
            lutemons = (ArrayList<Lutemon>) userReader.readObject();
            userReader.close();
        } catch (IOException e) {
            System.out.println("Lutemonien lataaminen epäonnistui");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Lutemonien lataaminen epäonnistui");
            e.printStackTrace();
        }
    }

    public void listLutemons() {

    }
}
