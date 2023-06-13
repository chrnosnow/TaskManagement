package org.example.todolist;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {

    @org.junit.jupiter.api.Test
    void add() {
        ToDoList list = new ToDoList();
        Task task1 = new Task("wake up");
        Task task2 = new Task("work", "high");
        list.addTask(task1);
        list.addTask(task2);
        List<Task> compareToList = list.getTodoList();
        assertEquals(2, compareToList.size());
        assertEquals(compareToList.get(1), task2);

        Task task3 = new Task("wake up", "low");
        list.addTask(task3);
        List<Task> newList = list.getTodoList();
        assertEquals(2, newList.size());//task3 was not added, because task 3 equals task2
    }

    @Test
    void remove() {
        ToDoList list = new ToDoList();
        Task task1 = new Task("wake up");
        Task task2 = new Task("work", "high");
        Task task3 = new Task("sleep", "low");
        task1.setStatus(TaskStatus.COMPLETED);
        list.addTask(task1);
        list.addTask(task2);
        list.addTask(task3);
        list.removeByNumber(1);
        assertEquals(2, list.getTodoList().size());//task1 was removed
        assertEquals(list.getTodoList().get(0), task2);//task2 is on index 0 in the list
    }
}