package com.mvc;

public class MVCTest {
    public static void main(String[] args) {
        Student student = new Student("SAI CHARAN", "529", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);
        controller.updateView();
        controller.setStudentName("SAI CHARAN TEJA");
        controller.setStudentId("21501A0529");
        controller.setStudentGrade("B");
        controller.updateView();
    }
}
