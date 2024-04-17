package eu.deic.oop;

import java.util.List;
import java.util.ArrayList;
public class Student {
    private int studentId;
    private String studentName;
    private int[] studentGrades;
    public Student(int studentId, String studentName, int[] studentGrades) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentGrades = studentGrades;
    }

    public float getAverage() {
        float studentGradeAverage = 0.0f;
        for (int i = 0; i < this.studentGrades.length; i++) {
                studentGradeAverage += studentGrades[i];
            }

            studentGradeAverage /= this.studentGrades.length;

            return studentGradeAverage;
        }

        public String toString() {
            return "\nStudent ID: " + this.studentId +
                    "\nStudent name: " + this.studentName +
                    "\nStudent grade average: " + this.getAverage();
        }


}
