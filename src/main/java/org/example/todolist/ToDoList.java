package org.example.todolist;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ToDoList implements Serializable {
    private List<Task> todoList;
    private int count = 0;

    private static final long serialVersionUID = 1L;

    public ToDoList() {
        this.todoList = new ArrayList<>();
    }

    public List<Task> getTodoList() {
        return todoList;
    }

    public void addTask(Task task) {
        if (todoList.contains(task)) {
            return;
        }

        task.setIndex(count++);
        todoList.add(task);
    }

    public int removeByNumber(int number) {
        if (number > 0 && number <= this.todoList.size()) {
            todoList.remove(number - 1);
            return number - 1;
        }

        return -1;
    }

    public void markAsDone(int number) {
        if (number > 0 && number <= this.todoList.size()) {
            todoList.get(number - 1).setStatus(TaskStatus.COMPLETED);
        }
    }

    public void sortByPriorityThenStatus() {
        Comparator<Task> compareByPriorityThenStatus =
                Comparator.comparing(Task::getPriority).thenComparing(Task::getStatus);
        List<Task> sortedList = todoList.stream().sorted(compareByPriorityThenStatus).collect(Collectors.toList());
        todoList.clear();
        for (Task task : sortedList) {
            todoList.add(task);
        }
    }

    public void defaultSort() {
        Comparator<Task> compareByIndex = Comparator.comparing(Task::getIndex);
        List<Task> sortedList = todoList.stream().sorted(compareByIndex).collect(Collectors.toList());
        todoList.clear();
        for (Task task : sortedList) {
            todoList.add(task);
        }
    }

    public void print() {
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ": " + todoList.get(i));
        }
    }

    public void saveToFile() {
        try {
            FileOutputStream fos = new FileOutputStream("t.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(todoList);
            oos.close();
            System.out.println("List saved successfully");
        } catch (IOException e) {
            System.out.println("List could not be saved..." + e);
        }
    }

    public void readFromFile() {
        try {
            FileInputStream fis = new FileInputStream("t.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Task> taskList = (List<Task>) ois.readObject();
            for (Task task : taskList) {
                this.addTask(task);
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File could not be opened..." + e);
        }
    }
}
