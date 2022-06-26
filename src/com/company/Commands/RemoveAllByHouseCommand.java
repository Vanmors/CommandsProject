package com.company.Commands;

import com.company.Database.CollectionDB;
import com.company.data.Flat;
import com.company.data.House;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Stack;

public class RemoveAllByHouseCommand implements ICommand, Serializable {
    private House h;
    private int id;
    private String user;
    /**
     * удаляет из коллекции все элементы, значение поля house которого эквивалентно заданному
     * @param st объект коллекции Stack
     */
    public RemoveAllByHouseCommand(House h,int id, String user){
        this.h = h;
        this.id = id;
        this.user = user;
    }

    @Override
    public String execute(Stack<Flat> st) {
        String result = "Complete";
        if (!st.empty()) {
            while(true) {
                try {

                    CollectionDB collectionDB = new CollectionDB();
                    while (!st.empty()){
                        st.pop();
                    }
                    collectionDB.parseCommandProject(st);
                    ArrayList<Flat> copyOfCollection = new ArrayList<>(st);
                    for (Flat flat : copyOfCollection) {
                        if (flat.getHouse().getName().equals(h.getName())
                                && flat.getHouse().getYear().equals(h.getYear())
                                && flat.getHouse().getNumberOfFlatsOnFloor().equals(h.getNumberOfFlatsOnFloor())) {
                            if (flat.getUser().equals(user)) {

                                collectionDB.removeObject("DELETE FROM collection WHERE id = " + "\'" + flat.getId() + "\'");
                                st.remove(flat.getId());
                                result = "Item removed";
                            }
                            else {
                                result = "You don't have permission";
                            }
                        }
                    }
                    break;
                }
                catch (InputMismatchException | SQLException e){
                    result = "Data entered incorrectly";
                }
            }
        }
        return result;
    }
}
