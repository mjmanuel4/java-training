package org.cms.model;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GenericInventory<T> {
    protected List<T> items;
    protected String pathName;

    public GenericInventory() {
        this.items = new ArrayList<T>();
    }

    public void addItem(T item){
        items.add(item);
    }

    public void removeItem(T item){
        items.remove(item);
    }

    @SuppressWarnings("unchecked")
    public void genericLoad() {
        List<T> items = new ArrayList<T>();
        try {
            FileInputStream fi = new FileInputStream(new File(pathName));
            ObjectInputStream oi = new ObjectInputStream(fi);

            items = (ArrayList<T>) oi.readObject();

            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error initializing stream.");
        } catch (ClassNotFoundException e) {
            // TODO
        }

        this.setItems(items);
    }

    public void genericUpdate(){
        try {
            FileOutputStream f = new FileOutputStream(new File(pathName));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(this.getItems());

            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error initializing stream.");
        }
    }
}
