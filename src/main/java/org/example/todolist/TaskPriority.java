package org.example.todolist;

public enum TaskPriority {
    HIGH(2), LOW(1), NONE(0);
    private int value;
    TaskPriority(int val){
        this.value = val;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
