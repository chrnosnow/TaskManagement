package org.example.todolist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testToString() {
        String result1 = "eat lunch (ongoing, no priority)";
        Task task1 = new Task("eat lunch");
        Task task2 = new Task("sleep", "high");
        assertEquals(result1, task1.toString());
        assertEquals("sleep", task2.getName());
        assertEquals(TaskPriority.HIGH, task2.getPriority());
    }

    @Test
    void testEquals() {
        Task task1 = new Task("work");
        Task task2 = new Task("work", "high");
        task1.setStatus(TaskStatus.COMPLETED);
        task2.setStatus(TaskStatus.COMPLETED);
        assertNotEquals(task1, new Task("work"));//will not fail, because new task has ONGOING status by default
        assertEquals(task1,task2);
    }
}