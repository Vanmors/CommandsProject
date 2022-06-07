package com.company.data;

import java.io.Serializable;

public class House implements Serializable {
    private static final long serialVersionUID = 1234567L;
    private String name; //Поле не может быть null
    private Integer year; //Значение поля должно быть больше 0
    private Integer numberOfFlatsOnFloor; //Значение поля должно быть больше 0

    public House(String name, Integer year, Integer numberOfFlatsOnFloor) {
        this.name = name;
        this.year = year;
        this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getNumberOfFlatsOnFloor() {
        return numberOfFlatsOnFloor;
    }

    @Override
    public String toString() {
        String result = String.format("Name: %s\nyear: %d\nnumberOfFlatsOnFloor:%d\n",
                getName(), getYear(), getNumberOfFlatsOnFloor());
//        if(getPostalAddress() == null) result += "Address: null";
//        else result += String.format("Address: {Street: %s, ZipCode: %s}", getPostalAddress().getStreet(), getPostalAddress().getZipCode());
        return result;
    }
}
