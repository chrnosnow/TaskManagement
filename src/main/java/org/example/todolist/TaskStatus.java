package org.example.todolist;

public enum TaskStatus {
    ONGOING(0), COMPLETED(1);

    private int value;
    TaskStatus(int val){
        this.value = val;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
