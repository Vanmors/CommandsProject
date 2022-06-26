package com.company.Commands;

import com.company.Database.CollectionDB;
import com.company.data.Flat;

import java.io.Serializable;
import java.sql.SQLException;
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
                    CollectionDB collectionDB = new CollectionDB();
                    while (!st.empty()){
                        st.pop();
                    }
                    collectionDB.parseCommandProject(st);
                    ArrayList<Flat> copyOfCollection = new ArrayList<>(st);
                    for (Flat flat : copyOfCollection) {
                        if (flat.getNumberOfRooms() < id) {
                            if (flat.getUser().equals(user)) {
                                collectionDB.removeObject("DELETE FROM collection WHERE id = " + "\'" + flat.getId() + "\'");
                                st.remove(flat.getId());
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
                catch (InputMismatchException | SQLException e){
                    result = "Data entered incorrectly";
                }
            }
        }
        return result;
    }
}
