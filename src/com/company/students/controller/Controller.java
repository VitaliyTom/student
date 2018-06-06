package com.company.students.controller;

import com.company.students.DAO.StudentDbDAO;
import com.company.students.entity.Group;
import com.company.students.entity.Student;
import com.company.students.entity.StudentSortBySurname;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    private StudentDbDAO dao = new StudentDbDAO();

    //get
    public List<Student> getStudent() {

        return dao.getStudent();
    }

    //add
    public void addStudent(Student student) {
        dao.addStudent(student);
    }

    //search
    public List<Student> getStudents(String surname) {
        List<Student> student = dao.getStudent();
        List<Student> Students = new ArrayList<>();
        for (Student st : student) {
            if (surname.equalsIgnoreCase(st.getSurname())) {
                Students.add(st);
            }
        }
        return Students;
    }

    //update
    public void update(Student student) {
        dao.update(student);
    }

    //delete
    public void delete(int id) {
        dao.delete(id);
    }


    public void addGroup(Group grp) {
        dao.addGroup(grp);
    }

    public void updateGroup(Group group) {
        dao.updateGroup(group);
    }

    public void deleteGroup(Group group) {
        dao.deleteGroup(group);
    }

    public  List<Group> outGroup() {
        return dao.outGroup();
    }

    public void getStudentGroup(Group group) {
        dao.getStudentGroup( group);
    }
}
