package org.example;

// Имеется список студентов. Каждый студент имеет имя, список оценок и специальность.
//         Найдите первых 5 студентов специальности "Информатика" с средним баллом выше 4.5, отсортированных по убыванию среднего балла.
//         В решении не использовать циклы! Только StreamAPI
//
//class Student {
//    private String name;
//    private List<Double> grades;
//    private String specialty;
//
//    public double getAverageGrade() {...}
//
//}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private List<Double> grades;
    private String specialty;

    public Student(String name, List<Double> grades, String specialty) {
        this.name = name;
        this.grades = grades;
        this.specialty = specialty;
    }

    public String getName() {return name;}

    public String getSpecialty() {return specialty;}

    public double getAverageGrade() {
        return grades.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Архипов Андрей", List.of(3.0, 4.0, 4.0), "информатика"));
        students.add(new Student("Борисов Богдан", List.of(3.0, 4.0, 5.0), "математика"));
        students.add(new Student("Волохов Василий", List.of(5.0, 4.0, 5.0), "информатика"));
        students.add(new Student("Горев Глеб", List.of(3.0, 4.0, 5.0), "история"));
        students.add(new Student("Дамбов Даниил", List.of(3.0, 4.0, 5.0), "математика"));
        students.add(new Student("Ежов Евгений", List.of(4.0, 4.0, 5.0), "информатика"));
        students.add(new Student("Красов Кирилл", List.of(5.0, 4.0, 5.0), "география"));
        students.add(new Student("Леонов Леонид", List.of(5.0, 5.0, 5.0), "информатика"));
        students.add(new Student("Морев Марк", List.of(3.0, 4.0, 5.0), "история"));
        students.add(new Student("Петров Павел", List.of(3.0, 4.0, 5.0), "математика"));
        students.add(new Student("Володин Андрей", List.of(5.0, 5.0, 4.0), "информатика"));
        students.add(new Student("Мальцев Дмитрий", List.of(5.0, 4.0, 5.0), "информатика"));
        students.add(new Student("Мартынов Конастантин", List.of(5.0, 5.0, 5.0), "информатика"));
        students.add(new Student("Ветров Денис", List.of(4.0, 5.0, 5.0), "информатика"));

        List<Student> filteredStudents = getFilteredStudents(students, "информатика", 4.5);
        filteredStudents.forEach(student -> System.out.println(student.getName() + " -> " + student.getAverageGrade()));
    }

    public static List<Student> getFilteredStudents(List<Student> students, String specialty, double averageGrade) {
        return students.stream()
                .filter(student -> student.getSpecialty().equals(specialty))
                .filter(student -> student.getAverageGrade() > averageGrade)
                .sorted(Comparator.comparing(Student::getAverageGrade).reversed())
                .collect(Collectors.toList());
    }
}
