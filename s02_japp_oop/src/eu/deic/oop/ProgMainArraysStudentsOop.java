package eu.deic.oop;

import java.util.ArrayList;
import java.util.List;
public class ProgMainArraysStudentsOop {

    public static void highestGradeStudent(List<Student> studentList) {
        int indexOfHighestGradeStudent = 0;
        float gradeAvg = -1.0f;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getAverage() > gradeAvg) {
                gradeAvg = studentList.get(i).getAverage();
                indexOfHighestGradeStudent = i;
            }
        }

        System.out.println(studentList.get(indexOfHighestGradeStudent));
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student(11, "John", new int[] {9, 10, 3}));
        studentList.add(new Student(12, "Delia", new int[] {5, 5, 6}));

        studentList.stream()
                .forEach(student -> System.out.println(student));

        highestGradeStudent(studentList);
    }
}
