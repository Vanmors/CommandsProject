package com.company.Database;

import com.company.data.Flat;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CollectionDB {

    public void insertIntoTable(Flat flat) {
        Connection connection = null;
        Statement statement = null;
        CollectionDB connectionDB = new CollectionDB();

        connection = connectionDB.getConnection();

        try {

            //Timestamp timestamp = Timestamp.from(flat.getCreationDate().toInstant());
            String date = String.valueOf(flat.getCreationDate().toLocalDate());
            String firstFlat = "INSERT INTO collection(Name, CoordinateX, CoordinateY, CreationTime, " +
                    "Area, NumberOfRooms, Furniture, " +
                    "TimeToMetroOnFoot, View, NameH, " +
                    "Year, NumberOfFlatsOnFloor, UserS) VALUES(" + "\'" + flat.getName() + "\'," +
                    flat.getCoordinates().getX() + "," +
                    flat.getCoordinates().getY() + "," +
                    "\'" + date + "\'" + "," +
                    flat.getArea() + "," +
                    flat.getNumberOfRooms() + "," +
                    flat.getFurniture() + "," +
                    flat.getTimeToMetroOnFoot() + "," +
                    "\'" + flat.getView() + "\'" + "," +
                    "\'" + flat.getHouse().getName() + "\'" + "," +
                    flat.getHouse().getYear() + "," +
                    flat.getHouse().getNumberOfFlatsOnFloor() + "," +
                    "\'" + flat.getUser() + "\'" + ")";
            System.out.println(firstFlat);
            statement = connection.createStatement();
            statement.executeUpdate(firstFlat);
            System.out.println("Value inserted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        Connection connection = null;
        Statement statement = null;
        CollectionDB connectionDB = new CollectionDB();

        connection = connectionDB.getConnection();

        try {
            String table = "CREATE TYPE VIEW AS ENUM ('BAD', 'TERRIBLE', 'PARK', 'STREET');" +
                    "CREATE TABLE IF NOT EXISTS collection(id SERIAL PRIMARY KEY, " +
                    "Name VARCHAR(200), " +
                    "CoordinateX INTEGER," +
                    "CoordinateY INTEGER," +
                    "CreationTime VARCHAR(200), " +
                    "Area VARCHAR(200), " +
                    "NumberOfRooms INTEGER, " +
                    "Furniture BOOLEAN," +
                    "TimeToMetroOnFoot INTEGER," +
                    "View VARCHAR(200)," +
                    "NameH VARCHAR(200)," +
                    "Year INTEGER," +
                    "NumberOfFlatsOnFloor INTEGER" +
                    "UserS VARCHAR(200) NOT NULL)";
            statement = connection.createStatement();
            statement.executeUpdate(table);
            System.out.println("finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "nav461");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return c;
    }

    public void clearTable() {
        Connection connection = null;
        Statement statement = null;
        CollectionDB connectionDB = new CollectionDB();

        connection = connectionDB.getConnection();

        try {
            String table = "DELETE FROM collection";
            statement = connection.createStatement();
            statement.executeUpdate(table);
            System.out.println("finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeObject(String sqlRequest) {
        Connection connection = null;
        Statement statement = null;
        CollectionDB connectionDB = new CollectionDB();

        connection = connectionDB.getConnection();

        try {
            String table = sqlRequest;
            statement = connection.createStatement();
            statement.executeUpdate(table);
            System.out.println("finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Flat flat) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        CollectionDB connectionDB = new CollectionDB();

        connection = connectionDB.getConnection();

        //Timestamp timestamp = Timestamp.from(flat.getCreationDate().toInstant());
        String date = String.valueOf(flat.getCreationDate().toLocalDate());
        String updateTable = "UPDATE collection SET " +
                "(Name, CoordinateX, CoordinateY, CreationTime," +
                "Area, NumberOfRooms, Furniture, " +
                "TimeToMetroOnFoot, View, NameH, " +
                "Year, NumberOfFlatsOnFloor, UserS) " +
                "= (" + "\'" + flat.getName() + "\'," +
                flat.getCoordinates().getX() + "," +
                flat.getCoordinates().getY() + "," +
                "\'" + date + "\'" + "," +
                flat.getArea() + "," +
                flat.getNumberOfRooms() + "," +
                flat.getFurniture() + "," +
                flat.getTimeToMetroOnFoot() + "," +
                "\'" + flat.getView() + "\'" + "," +
                "\'" + flat.getHouse().getName() + "\'" + "," +
                flat.getHouse().getYear() + "," +
                flat.getHouse().getNumberOfFlatsOnFloor() + "," + "\'" + flat.getUser() + "\'" + ") where id = " + id + ")";

        statement = connection.createStatement();
        statement.executeUpdate(updateTable);
    }

}