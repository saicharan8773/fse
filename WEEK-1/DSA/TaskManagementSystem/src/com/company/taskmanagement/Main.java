package com.company.taskmanagement;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();

        Task task1 = new Task("T001", "Task 1", "Pending");
        Task task2 = new Task("T002", "Task 2", "In Progress");
        Task task3 = new Task("T003", "Task 3", "Completed");

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        System.out.println("Traverse Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearch Task with ID T002:");
        System.out.println(taskList.searchTask("T002"));

        System.out.println("\nDelete Task with ID T001:");
        taskList.deleteTask("T001");
        taskList.traverseTasks();
    }
}
