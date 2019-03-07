package com.sweet.JVM.singleton;

import java.io.Serializable;

/**
 * Author:sweet
 * Created:2019/1/22
 */
public class Teacher implements Serializable {
    private String name;
    private String direction;

    public Teacher(String name, String direction) {
        this.name = name;
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }
}
