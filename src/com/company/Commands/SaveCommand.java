//package com.company.Commands;
//
//import com.company.data.Flat;
//import com.opencsv.CSVWriter;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//public class SaveCommand implements ICommand, Serializable {
//    /**
//     * сохранить коллекцию в файл
//     * @param f файл в который сохраняется коллекция
//     * @param st объект коллекции Stack
//     * @throws IOException
//     */
//    static public String save(String file, Stack<Flat> st) {
//        List<String[]> list = creatCsvData(st);
//        try (CSVWriter writer = new CSVWriter(new PrintWriter(file))) {
//            writer.writeAll(list);
//            System.out.println("Collection saved");
//        } catch (IOException e) {
//            return "File not found";
//        }
//        return "Complete";
//    }
//
//    /**
//     * создаёт список данных из коллекции
//     * @param st объект коллекции Stack
//     * @return list
//     */
//    private static List<String[]> creatCsvData(Stack<Flat> st) {
//        ArrayList<Flat> copyOfCollection = new ArrayList<>(st);
//        List<String[]> list = new ArrayList<>();
//        for (Flat flat: copyOfCollection) {
//            list.add(flat.toStringForSave());
//        }
//        return list;
//    }
//
//    @Override
//    public String execute(Stack<Flat> st) {
//        return null;
//    }
//}
//
