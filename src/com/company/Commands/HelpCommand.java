package com.company.Commands;

import com.company.data.Flat;

import java.io.Serializable;
import java.util.Stack;

public class HelpCommand implements Serializable, ICommand {
    /**
     * выводит справку по доступным командам
     *
     * @return
     */
    @Override
    public String execute(Stack<Flat> st) {
        String s = "help : output help for available commands\n" +
                "info : output information about the collection (type, initialization date, number of items, etc.) to the standard output stream\n" +
                "show : output to the standard output stream all the elements of the collection in a string representation\n" +
                "add {element} : add a new item to the collection\n" +
                "update id {element} : update the value of a collection item whose id is equal to the specified one\n" +
                "clear : delete all collection\n" +
                "remove_by_id id : delete an item from the collection by its id\n" +
                "execute_script file_name : read and execute the script from the specified file. The script contains commands in the same form in which they are entered by the user in interactive mode\n" +
                "exit : end the program (with saving to a file)\n" +
                "add_if_min {element} : add a new item to the collection if its value is less than that of the smallest item in this collection\n" +
                "remove_lower {element} : remove all items smaller than the specified one from the collection\n" +
                "reorder : sort the collection in the reverse order of the current one\n" +
                "remove_all_by_house house : remove from the collection all items whose house field value is equivalent to the specified\n" +
                "average_of_number_of_rooms : output the average value of the numberOfRooms field for all elements of the collection\n" +
                "max_by_furniture : output any object from the collection whose furniture field value is the maximum";
        return s;
    }

}
