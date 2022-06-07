package com.company.data;

import java.io.Serializable;
import java.time.LocalDate;

public class Flat implements Serializable {
    private static final long serialVersionUID = 1234567L;
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int area; //Значение поля должно быть больше 0
    private Long numberOfRooms; //Поле может быть null, Значение поля должно быть больше 0
    private Boolean furniture; //Поле не может быть null
    private Long timeToMetroOnFoot; //Значение поля должно быть больше 0
    private View view; //Поле не может быть null
    private House house; //Поле может быть null
    private String user;

    public Flat(Integer id, String name, Coordinates coordinates, java.time.ZonedDateTime creationDate, int area,
                Long numberOfRooms, Boolean furniture, Long timeToMetroOnFoot, View view, House house, String user) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.furniture = furniture;
        this.timeToMetroOnFoot = timeToMetroOnFoot;
        this.view = view;
        this.house = house;
        this.user = user;
    }
    public Integer setID(int i){
        id = i;
        return null;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public java.time.ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public int getArea() {
        return area;
    }

    public Long getNumberOfRooms() {
        return numberOfRooms;
    }

    public Boolean getFurniture() {
        return furniture;
    }

    public Long getTimeToMetroOnFoot() {
        return timeToMetroOnFoot;
    }

    public View getView() {
        return view;
    }

    public House getHouse() {
        return house;
    }

    public String getUser(){
        return user;
    }

    @Override
    public String toString() {
        String result = String.format("Id: %d\nName: %s\nCoordinates: {x: %d, y: %d}\n" +
                        "Creation Time: %s\nArea: %d\nNumberOfRooms: %d\n" +
                        "Furniture: %b\nTimeToMetroOnFoot: %d\nView: %s\n" +
                        "Name: %s\nYear: %d\nNumberOfFlatsOnFloor: %d\n",
                getId(), getName(), getCoordinates().getX(),
                getCoordinates().getY(), getCreationDate(), getArea(),
                getNumberOfRooms(), getFurniture(), getTimeToMetroOnFoot(),
                getView(), getHouse().getName(),
                getHouse().getYear(), getHouse().getNumberOfFlatsOnFloor());
//        if(getPostalAddress() == null) result += "Address: null";
//        else result += String.format("Address: {Street: %s, ZipCode: %s}", getPostalAddress().getStreet(), getPostalAddress().getZipCode());
        return result;
    }
    public String[] toStringForSave(){
        String[] array = {String.valueOf(getId()), getName(), String.valueOf(getCoordinates().getX()),
                String.valueOf(getCoordinates().getY()), String.valueOf(getCreationDate()),
                String.valueOf(getArea()), String.valueOf(getNumberOfRooms()),
                String.valueOf(getFurniture()), String.valueOf(getTimeToMetroOnFoot()),
                String.valueOf(getView()), getHouse().getName(), String.valueOf(getHouse().getYear()),
                String.valueOf(getHouse().getNumberOfFlatsOnFloor())};
        return array;
    }
}
