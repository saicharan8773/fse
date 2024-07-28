package com.company.taskmanagement;

public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public boolean deleteTask(String taskId) {
        if (head == null) {
            return false;
        }
        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId().equals(taskId)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
