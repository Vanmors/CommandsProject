package com.company.Commands;

import com.company.Database.CollectionDB;
import com.company.data.Flat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Stack;

public class RemoveLowerCommand implements ICommand, Serializable {
    private int id;
    private String user;
    /**
     * удаляет из коллекции все элементы, меньшие, чем заданный
     * @param st объект коллекции Stack
     * @param n передаёт массив из названия команды и заданного числа
     */
    public RemoveLowerCommand(int id, String user){
        this.id = id;
        this.user = user;
    }

    public String execute(Stack<Flat> st) {
        String result = "Complete";
        if (!st.empty()) {
            while (true) {
                try {
                    ArrayList<Flat> copyOfCollection = new ArrayList<>(st);
                    for (Flat flat : copyOfCollection) {
                        if (flat.getNumberOfRooms() < id) {
                            if (flat.getUser().equals(user)) {
                                CollectionDB collectionDB = new CollectionDB();
                                collectionDB.removeObject("DELETE FROM collection WHERE id = " + st.get(flat.getId() - 1));
                                st.remove(st.get(flat.getId() - 1));
                            }
                            else {
                                result = "You don't have permission";
                            }
                        }
                    }
                    if (id>=0) {
                        break;
                    }
                    else{
                        result = "Data entered incorrectly";
                    }
                }
                catch (InputMismatchException e){
                    result = "Data entered incorrectly";
                }
            }
        }
        return result;
    }
}
