package com.mvc;

public class MVCTest {
    public static void main(String[] args) {
        // Create a Student model
        Student student = new Student("John Doe", "S12345", "A");

        // Create a StudentView
        StudentView view = new StudentView();

        // Create a StudentController
        StudentController controller = new StudentController(student, view);

        // Update view
        controller.updateView();

        // Change student details
        controller.setStudentName("SAI CHARAN TEJA");
        controller.setStudentId("21501A0529");
        controller.setStudentGrade("B");

        // Update view with new details
      
        controller.updateView();
    }
}
