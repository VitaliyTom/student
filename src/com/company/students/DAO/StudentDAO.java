package com.company.students.DAO;

import com.company.students.entity.Group;
import com.company.students.entity.Student;
import java.util.List;

public interface StudentDAO {

    List<Student> getStudent();

    void addStudent(Student student);

    void update(Student student);

    void delete(int id);

    void addGroup(Group group);

    void updateGroup(Group group);

    void deleteGroup(Group group);

    List<Group> outGroup();

    void getStudentGroup(Group group);
}
