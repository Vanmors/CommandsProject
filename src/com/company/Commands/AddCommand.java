package com.company.Commands;

import com.company.Database.CollectionDB;
import com.company.data.Flat;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.Stack;

public class AddCommand implements Serializable, ICommand {
    private Flat f;
    private String user;

    /**
     * добавляет элемент в коллекцию
     *
     * @param st объект коллекции Stack
     */

    public AddCommand(Flat f) {
        this.f = f;
    }

    public String execute(Stack<Flat> st) {
        CollectionDB collectionDB = new CollectionDB();
        collectionDB.insertIntoTable(f);
        try {
            f.setID(st.peek().getId() + 1);
            st.push(f);
        } catch (EmptyStackException e) {
            f.setID(1);
            st.push(f);
        }
        return "Object insert in collection";
    }

}
