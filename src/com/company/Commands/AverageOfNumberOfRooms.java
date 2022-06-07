package com.company.Commands;

import com.company.data.Flat;

import java.io.Serializable;
import java.util.Stack;

public class AverageOfNumberOfRooms implements Serializable, ICommand{

    /**
     * выводит среднее значение поля numberOfRooms для всех элементов коллекции
     * @param st объект коллекции Stack
     */
    @Override
    public String execute(Stack<Flat> st) {
        return String.valueOf(
                st
                    .stream()
                    .mapToLong(Flat::getNumberOfRooms)
                    .average()
                    .orElse(0)
        );
    }

}
