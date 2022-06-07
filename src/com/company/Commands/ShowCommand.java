package com.company.Commands;

import com.company.data.Flat;

import java.io.Serializable;
import java.util.Stack;
import java.util.stream.Collectors;

public class ShowCommand implements Serializable, ICommand {
    /**
     * выводит в стандартный поток вывода все элементы коллекции в строковом представлении
     * @param st объект коллекции Stack
     */
    @Override
    public String execute(Stack<Flat> st) {
        if (!st.empty()){
            return st
                    .stream()
                    .map(Flat::toString)
                    .collect(Collectors.joining("\n============\n"));
        }
        else{
            return "collection is empty";
        }
    }

}

