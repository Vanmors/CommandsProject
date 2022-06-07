package com.company.Commands;

import com.company.data.Flat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class InfoCommand implements Serializable, ICommand {
    /**
     * выводит в стандартный поток вывода информацию о коллекции
     * @param st объект коллекции Stack
     */
    @Override
    public String execute(Stack<Flat> st) {
        ArrayList<Flat> list = new ArrayList<>(st);
        java.time.ZonedDateTime initializationDate = null;
        int count = 0;
        for (Flat flat : list) {
            initializationDate = flat.getCreationDate();
            count += 1;
        }
        return "Type collection: Stack" +
                "\ninitialization date: " + initializationDate +
                "\nnumber of elements: "+ count;
    }

}
