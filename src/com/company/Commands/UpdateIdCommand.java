package com.company.Commands;

import com.company.Database.CollectionDB;
import com.company.data.Flat;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class UpdateIdCommand implements ICommand, Serializable {
    private Flat f;
    private int id;
    private String user;

    /**
     * обновляет значение элемента коллекции, id которого равен заданному
     *
     * @param st объект коллекции Stack
     * @param n  передаёт массив из названия команды и заданного числа
     */

    public UpdateIdCommand(Flat f, int id, String user) {
        this.f = f;
        this.id = id;
        this.user = user;
    }

    @Override
    public String execute(Stack<Flat> st) {
        String result = "Element changed";
        f.setID(id);
        CollectionDB collectionDB = new CollectionDB();
        ArrayList<Flat> list = new ArrayList<>(st);
        try {
            if (list.get(id - 1).getUser().equals(user)) {

                collectionDB.update(id, list.get(id - 1));
                list.set(id - 1, f);
                while (!st.empty()) {
                    st.pop();
                }
                for (Flat flat : list) {
                    st.push(flat);
                }
            }
            else {
                result = "You don't have permission";
            }
        } catch (IndexOutOfBoundsException e) {
            result = "There is no element with this id";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
