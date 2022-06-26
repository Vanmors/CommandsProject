package com.company.Commands;

import com.company.Database.CollectionDB;
import com.company.data.Coordinates;
import com.company.data.Flat;
import com.company.data.House;
import com.company.data.View;

import java.io.IOException;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class UpdateIdScriptCommand {
    /**
     *
     * @param st объект коллекции Stack
     * @param file файл со скриптом
     * @param n передаёт массив из названия команды и заданного числа
     * @throws IOException
     */
    static public void updateIdScriptCommand(Stack<Flat> st, Scanner file, String[] n, String user) throws IOException, SQLException {
        while (true) {
            try {
                String name = setName(file);
                Coordinates coordinates = setCoordinates(file);
                int area = setArea(file);
                long numberOfRooms = setNumberOfRooms(file);
                Boolean furniture = setFurniture(file);
                long timeToMetro = setTimeToMetroOnFoot(file);
                View view = setView(file);
                House house = setHouse(file);
                if (name == null ||
                        coordinates == null ||
                        area == -1 ||
                        numberOfRooms == -1 ||
                        furniture == null ||
                        timeToMetro == -1 ||
                        view == null ||
                        house == null) {
                    System.out.println("Неверно введён скрипт");
                } else {
                    try {
                        int id = Integer.parseInt(n[1]);
                        Flat f = new Flat(id, name, coordinates, setCreationDate(),
                                area, numberOfRooms, furniture, timeToMetro,
                                view, house, user);
                        ArrayList<Flat> list = new ArrayList<>(st);
                        if (list.get(id - 1).getUser().equals(user)) {
                            CollectionDB collectionDB = new CollectionDB();
                            collectionDB.update(id, list.get(id - 1));
                            list.set(id - 1, f);
                            while (!st.empty()) {
                                st.pop();
                            }
                            for (Flat flat : list) {
                                st.push(flat);
                                System.out.println(flat);
                            }
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Элемента с таким id не существует");
                    }
                    break;
                }
            }
            catch (NoSuchElementException e){
                System.out.println("Неверно введён скрипт");
                break;
            }
        }
    }
    /**
     * считывает и возвращает Name
     * @param file файл со скриптом
     * @return Name
     */
    static public String setName(Scanner file) {
        String Name = file.nextLine();
        if ((Name.trim()).equals("")){
            return null;
        }
        else{
            return Name;
        }
    }
    /**
     * считывает и возвращает Coordinates
     * @param file файл со скриптом
     * @return Coordinates
     */
    static public Coordinates setCoordinates(Scanner file) {

                int x = file.nextInt();
                long y = file.nextLong();
                if (x>=0 && y>=0) {
                    return new Coordinates(x,y);
                }
                else{
                    System.out.println("Неверно введён скрипт");
                }
        return null;
    }
    /**
     * возвращает CreationDate
     * @return CreationDate
     */
    static public ZonedDateTime setCreationDate(){
        return ZonedDateTime.now();
    }
    static public int setArea(Scanner file){
                int area = file.nextInt();
                if (area>=0) {
                    return area;
                }
                else{
                    System.out.println("Неверно введён скрипт");
                }
        return -1;
    }
    /**
     * считывает и возвращает NumberOfRooms
     * @param file файл со скриптом
     * @return NumberOfRooms
     */
    static public Long setNumberOfRooms(Scanner file){
                Long numberOfRooms = file.nextLong();
                if (numberOfRooms>=0) {
                    return numberOfRooms;
                }
                else{
                    System.out.println("Неверно введён скрипт");
                }
        return (long) -1;
    }
    /**
     * считывает и возвращает Furniture
     * @param file файл со скриптом
     * @return Furniture
     */
    static public Boolean setFurniture(Scanner file){
                Boolean furniture = file.nextBoolean();
                return furniture;
    }
    /**
     * считывает и возвращает TimeToMetroOnFoot
     * @param file файл со скриптом
     * @return TimeToMetroOnFoot
     */
    static public Long setTimeToMetroOnFoot(Scanner file){
                Long timeToMetroOnFoot = file.nextLong();
                if (timeToMetroOnFoot>=0) {
                    return timeToMetroOnFoot;
                }
                else {
                    System.out.println("Неверно введён скрипт");
                }
        return (long) -1;
    }
    /**
     * считывает и возвращает View
     * @param file файл со скриптом
     * @return View
     */
    static public View setView(Scanner file) {
        View v = null;
                String view = file.nextLine();
                view = file.nextLine();
                if (view.equals("TERRIBLE")) {
                    v = View.TERRIBLE;
                } else if (view.equals("STREET")) {
                    v = View.STREET;
                } else if (view.equals("BAD")) {
                    v = View.BAD;
                } else if (view.equals("PARK")) {
                    v = View.PARK;
                }
                return v;
    }
    /**
     * считывает и возвращает House
     * @param file файл со скриптом
     * @return House
     */
    static public House setHouse(Scanner file) {
        String Name = file.nextLine();
        Integer year = file.nextInt();
        Integer numberOfFlatsOnFloor = file.nextInt();
        if (year >= 0 && numberOfFlatsOnFloor >= 0) {
            return new House(Name, year, numberOfFlatsOnFloor);
        } else {
            System.out.println("Неверно введён скрипт");
        }
        return null;
    }
}