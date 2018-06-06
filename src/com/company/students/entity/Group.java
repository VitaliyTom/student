package com.company.students.entity;

public class Group {

    private String group;
    private int id;

    public Group() {
    }

    public Group(int id, String group) {
        this.group = group;
        this.id = id;
    }

    public Group(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  group ;
    }
}
