package com.company.Commands;

import com.company.Database.CollectionDB;
import com.company.data.Flat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Stack;

public class RemoveByIdCommand implements ICommand, Serializable {
    private String result;
    private int id;
    private String user;
    /**
     * удаляет элемент из коллекции по его id
     *
     * @param st объект коллекции Stack
     * @throws ArrayIndexOutOfBoundsException
     */
    public RemoveByIdCommand(int id, String user){
        this.id = id;
        this.user = user;
    }

    @Override
    public String execute(Stack<Flat> st) throws ArrayIndexOutOfBoundsException {
        ArrayList<Flat> list = new ArrayList(st);
        long count = list.size();
            try {
                if (id > 0 || id < count) {
                    if (list.get(id).getUser().equals(user)) {
                        CollectionDB collectionDB = new CollectionDB();
                        collectionDB.removeObject("DELETE FROM collection WHERE id = " + id);
                        st.remove(st.get(id - 1));
                        result = "Item removed";
                    }
                    else {
                        result = "You don't have permission";
                    }
                } else {
                    result = "Data entered incorrectly";
                }
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                result = "Data entered incorrectly";
            }
        return result;
    }
}
