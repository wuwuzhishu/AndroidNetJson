package com.sptpc.app.androidnetjson.model;

/**
 * Created by wwb on 2018/4/9.
 */
public class Subject2Child {
    private String id;
    private String time;
    private String distance;

    public Subject2Child(String id, String time, String distance) {
        this.id = id;
        this.time = time;
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
