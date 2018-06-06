package com.company.students.DAO;

import com.company.students.connections.MySqlConnection;
import com.company.students.entity.Group;
import com.company.students.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDbDAO implements StudentDAO {


    @Override
    public List<Student> getStudent() {

            List<Student> students = new ArrayList<>();
            try (Connection connection = MySqlConnection.getConnection()){
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM student INNER JOIN students.group on student.grp_id = students.group.id");
                while (result.next()){
                    Student student = new Student();
                    student.setId(result.getInt("id"));
                    student.setName(result.getString("Имя"));
                    student.setSurname(result.getString("Фамилия"));
                    student.setMiddleName(result.getString("Отчество"));
                    student.setAge(result.getInt("Возраст"));
                    student.setGrp(result.getString("grp"));
                    students.add(student);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
           return students;

    }

    @Override
    public void addStudent(Student student) {
        try(Connection connection = MySqlConnection.getConnection()){
            String sql = "INSERT INTO student (Имя, Фамилия, Отчество, Возраст, grp_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getMiddleName());
            statement.setInt(4, student.getAge());
            statement.setString(5, student.getGrp());

            statement.execute();
        } catch (SQLException e) {
            System.out.println("error2");
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        try(Connection connection = MySqlConnection.getConnection()){
            String sql = "UPDATE student SET Имя = ?, Фамилия = ?, Отчество = ?, Возраст = ?, grp_id = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getMiddleName());
            statement.setInt(4, student.getAge());
            statement.setString(5, student.getGrp());
            statement.setInt(6, student.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(Connection connection = MySqlConnection.getConnection()){
            String sql = "DELETE FROM `students`.`students` WHERE `id`="+id+"";
            PreparedStatement statement = connection.prepareStatement(sql);


            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addGroup(Group group) {

        try(Connection connection = MySqlConnection.getConnection()){
            String sql = "INSERT INTO `students`.`group` ( `grp`) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, group.getGroup());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("error2");
            e.printStackTrace();
        }

    }

    @Override
    public void updateGroup(Group group) {
        try(Connection connection = MySqlConnection.getConnection()){
            String sql = "UPDATE `students`.`group` SET grp = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, group.getGroup());
            statement.setInt(2, group.getId());


            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGroup(Group group) {
        try(Connection connection = MySqlConnection.getConnection()){
            String sql = "DELETE FROM `students`.`group` WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, group.getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Group> outGroup() {
        List<Group> groups = new ArrayList<>();
        try (Connection connection = MySqlConnection.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM students.`group`");
            while (result.next()){
                Group group = new Group();
                group.setId(result.getInt("id"));
                group.setGroup(result.getString("grp"));

                groups.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }

    @Override
    public void getStudentGroup(Group group) {
        int gp=group.getId();
        List<Student> students = new ArrayList<>();
        try (Connection connection = MySqlConnection.getConnection()){
            Statement statement = connection.createStatement();
           // System.out.println("test1");
            ResultSet result = statement.executeQuery("SELECT * FROM students.student INNER JOIN students.group on student.grp_id = students.group.id where grp_id ="+gp+"");
          //  System.out.println("test2");

            while (result.next()){
            //    System.out.println("test3");
                Student student = new Student();
                student.setId(result.getInt("id"));
                student.setName(result.getString("Имя"));
                student.setSurname(result.getString("Фамилия"));
                student.setMiddleName(result.getString("Отчество"));
                student.setAge(result.getInt("Возраст"));
                student.setGrp(result.getString("grp"));
                students.add(student);
                System.out.println(student);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
