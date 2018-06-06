package com.company.students.entity;

import java.util.Comparator;

public class StudentSortBySurname implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
