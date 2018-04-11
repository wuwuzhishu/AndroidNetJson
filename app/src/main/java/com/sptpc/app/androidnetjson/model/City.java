package com.sptpc.app.androidnetjson.model;

/**
 * Created by wwb on 2018/4/3.
 */
public class City {
    private int ID;
    private String name;

    public City() {
    }

    public City(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
