package com.company.Commands;

import com.company.Database.CollectionDB;
import com.company.data.Flat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class ClearCommand implements Serializable, ICommand {
    private String user;

    public ClearCommand(String user) {
        this.user = user;
    }

    /**
     * очищает коллекцию
     *
     * @param st объект коллекции Stack
     */
    @Override
    public String execute(Stack<Flat> st) {
        int size = st.size();
        int userSize = 0;
        ArrayList<Flat> list = new ArrayList<>(st);

        for (Flat flat : list) {
            if (flat.getUser().equals(user)) {
                userSize += userSize;
            }
        }

        if (userSize == size) {
            CollectionDB collectionDB = new CollectionDB();
            collectionDB.clearTable();
            while (!st.empty()) {
                st.pop();
            }
            return "Complete";
        } else {
            return "You don't have permission";
        }

    }

}
