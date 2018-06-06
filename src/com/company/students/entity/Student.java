package com.company.students.entity;



public class Student {
    Group group = new Group();
    private String grp = group.getGroup();
    private String name;        //имя
    private String surname;     //фамилия
    private String middleName;  //отчество
    private int age;
    private int id;


    public Student() {
    }

    public Student(String name, String surname, String middleName, int age) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.age = age;
    }

    public Student( String name, String surname, String middleName, int age, String grp, int id) {
        this.grp = grp;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.age = age;
        this.id = id;
    }

    public Student(String name, String surname, String middleName, int age, String grp) {
        this.grp = grp;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.age = age;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    @Override
    public String toString() {
        return "Студент{" +
                "ФИО = " + surname + " " + name + " " + middleName +  " " +
                ", Возраст = " + age +
                ", Группа = " + grp +
                ", id = " + id +
                '}';
    }

}
