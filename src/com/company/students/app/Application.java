package com.company.students.app;

/*
    Разработать приложение "База студентов".
        Сущности:
        - Группа(поля: номер или название группы)
        - Студент(поля: ФИО, возраст, группа)
                   Функционал:
    +   - Добавление группы
    +   - Редактирование группы
    +   - Удаление группы
    +   - Добавление студента
    +   - Редактирование студента
    +   - Удаление студента
    +   - Вывод всех студентов (с возможностью выбора сортировки по ФИО или возрасту)
    +   - Поиск студентов по ФИО
    +   - Вывод студентов конкретной группы
    +   - Вывод всех групп
    +   Примечание: При удалении группы, удаляются все студенты которые в ней учились.

    - Возможность вывода всех студентов в текстовый файл, пример файла:
                ***** С 15 *****
            1) Иванов Иван Иванович
            2) Петров Петр Петрович
                ***** С 16 *****
            1) Сидоров Степан Алексеевич

*/


import com.company.students.controller.Controller;
import com.company.students.entity.Group;
import com.company.students.entity.Student;
import com.company.students.entity.StudentSortByAge;
import com.company.students.entity.StudentSortBySurname;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {
    private Scanner scanner = new Scanner(System.in);
    private Controller controller = new Controller();
    private int action;
    private int action2;


    public void start() {
        System.out.println("База студентов!");
        run();
        System.out.println("Пока!");
    }

    public void run() {
        do {
            showMenu();
        } while (select());
    }

    public void run2() {
        do {
            showMenu2();
        } while (select2());
    }

    private boolean select() {
        switch (action()) {
            case 1:
                addGroup();

                break;
            case 2:
                updateGroup();

                break;
            case 3:
                deleteGroup();

                break;
            case 4:
                addStudent();

                break;
            case 5:
                update();

                break;
            case 6:
                delete();

                break;
            case 7:
                run2();

                break;
            case 8:
                search();

                break;
            case 9:
                getStudentGroup();

                break;
            case 10:
                outGroup();

                break;
            case 0:
                return false;
        }
        return true;
    }

    private void getStudentGroup() {

        System.out.println("Введите id группы");
        Group   group = new Group();
        group.setId(scanner.nextInt());
        controller.getStudentGroup(group);



    }

    private void outGroup() {
        List<Group> groups = new ArrayList<>();
        for (Group getGroup : controller.outGroup()) {
            groups.add(getGroup);
        }

        showGroups(groups);
    }

    private void deleteGroup() {
        Group   group = new Group();
        System.out.println("Введите id группы для удаления");
        group.setId(scanner.nextInt());
        controller.deleteGroup(group);
    }

    private void updateGroup() {
        System.out.println("Введите id группы");
        Group   group = new Group();
        group.setId(scanner.nextInt());
        System.out.println("Введите новое название  группы");
        group.setGroup(scanner.next());
        controller.updateGroup(group);
        System.out.println("Сохранено");

    }

    private void addGroup() {
        System.out.println("Введите название группы");
        Group   group = new Group();
        group.setGroup(scanner.next());
        controller.addGroup(group);
        System.out.println("Сохранено");

    }

    private boolean select2() {
        switch (action2()) {
            case 1:
                //System.out.println("test");
                getStudentSortBySurename();

                break;
            case 2:
                getStudentSortByAge();

                break;
            case 0:
                return false;
        }
        return true;
    }

    private void showMenu2() {
        System.out.println();
        System.out.println(" Введите 1 - Вывод всех студентов по ФИО ");
        System.out.println(" Введите 2 - Вывод всех студентов  по возрасту");
        System.out.println(" Введите 0 -  Выход в предыдущее меню");
    }

    private void delete() {
        System.out.println("Введите id студента для удаления");
        int id = scanner.nextInt();
        controller.delete(id);
        System.out.println("сохранено");


    }

    private void search() {
        System.out.println("Введите Фамилию студента для поиска");
        String surname = scanner.next();
        List<Student> students = controller.getStudents(surname);
        System.out.println("Все студенты " + surname);
        showStudents(students);
    }

    private void showStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void showGroups(List<Group> groups) {
        for (Group group : groups) {
            System.out.println(group);
        }
    }

    private void update() {
        System.out.println("Введите id студента для редактирования");
        int id = scanner.nextInt();
        System.out.println("Введите новые Фаимилию студента");
        String surname = scanner.next();
        System.out.println("Введите новые Имя студента");
        String name = scanner.next();
        System.out.println("Введите новые Отчество студента");
        String middleName = scanner.next();
        System.out.println("Введите новый возвраст студента");
        int age = scanner.nextInt();
        System.out.println("Введите новый id группы ");
        String grp = scanner.next();
        Student student = new Student(name, surname, middleName, age, grp, id);
        controller.update(student);
        System.out.println("сохранено");


    }

    private void addStudent() {

        System.out.println("Введите Фамилию");
        String surname = scanner.next();
        System.out.println("Введите Имя");
        String name = scanner.next();
        System.out.println("Введите Отчество");
        String middleName = scanner.next();
        System.out.println("Введите возраст");
        int age = scanner.nextInt();
        System.out.println("Введите id группы");
        String grp = scanner.next();

        Student student = new Student(name, surname, middleName, age, grp);
        controller.addStudent(student);
        System.out.println("Сохранено");

    }

    private void getStudentSortBySurename() {
        List<Student> sortStudent = new ArrayList<>();
        for (Student getStudent : controller.getStudent()) {
            sortStudent.add(getStudent);
        }
        Collections.sort(sortStudent, new StudentSortBySurname());
        System.out.println("~~~ Список студентов ~~~");
        showStudents(sortStudent);
    }

    private void getStudentSortByAge() {
        List<Student> sortStudent = new ArrayList<>();
        for (Student getStudent : controller.getStudent()) {
            sortStudent.add(getStudent);
        }
        Collections.sort(sortStudent, new StudentSortByAge());
        System.out.println("~~~ Список студентов ~~~");
        showStudents(sortStudent);
    }

    private int action() {
        action = scanner.nextInt();
        return action;
    }

    private int action2() {
        action2 = scanner.nextInt();
        return action2;
    }

    private void showMenu() {
        System.out.println();
        System.out.println(" Введите 1 - Добавление группы");
        System.out.println(" Введите 2 - Редактирование группы");
        System.out.println(" Введите 3 - Удаление группы");
        System.out.println(" Введите 4 - Добавление студента");
        System.out.println(" Введите 5 - Редактирование студента");
        System.out.println(" Введите 6 - Удаление студента");
        System.out.println(" Введите 7 - Вывод всех студентов (с возможностью выбора сортировки по ФИО или возрасту)");
        System.out.println(" Введите 8 - Поиск студентов по ФИО");
        System.out.println(" Введите 9 - Вывод студентов конкретной группы");
        System.out.println(" Введите 10 - Вывод всех групп");
        System.out.println(" Введите 0 -  Выход");
    }


}
