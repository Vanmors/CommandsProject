package com.company.Commands;

import com.company.Database.CollectionDB;
import com.company.data.Flat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;


public class AddIfMinCommand implements ICommand, Serializable {
    private Flat f;
    private int id;
    /**
     * добавляет элемент в коллекцию если NumberOfRooms меньше, чем у остальных объектов
     * @param st объект коллекции Stack
     */
    public AddIfMinCommand(Flat f, int id){
        this.f = f;
        this.id = id;
    }
    @Override
    public String execute(Stack<Flat> st) {
        ArrayList<Flat> list = new ArrayList<>(st);
        Long minNumberOfRooms = list.get(0).getNumberOfRooms();
        for (Flat flat: list){
            if (flat.getNumberOfRooms() < minNumberOfRooms){
                minNumberOfRooms = flat.getNumberOfRooms();
            }
        }
        if (f.getNumberOfRooms()<minNumberOfRooms){
            f.setID(st.peek().getId()+1);
            CollectionDB collectionDB = new CollectionDB();
            collectionDB.insertIntoTable(f);
            st.push(f);
        }
        return "Complete";
    }
}
