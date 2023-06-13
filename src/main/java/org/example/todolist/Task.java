package org.example.todolist;

import java.io.Serializable;

public class Task implements Serializable {
    private String name;
    private TaskPriority priority;
    private TaskStatus status;
    private int index; //used for keeping tasks writing order, when using the default sort
    private static final long serialVersionUID = 1L;

    public Task(String name){
        this.name = name;
        this.priority = TaskPriority.NONE;
        this.status = TaskStatus.ONGOING;
        this.index = 0;
    }

    public Task(String name, String priority){
        this.name = name;
        this.priority = TaskPriority.valueOf(priority.toUpperCase());
        this.status = TaskStatus.ONGOING;
        this.index = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString(){
        String taskStatus = this.getStatus().toString().toLowerCase();
        String taskPriority = this.getPriority().toString().toLowerCase();
        if (taskPriority.equals("none")){
            taskPriority = "no";
        }
        return name + " (" + taskStatus + ", " + taskPriority + " priority)";
    }

    @Override
    public boolean equals(Object other){
        if(other == null){
            return false;
        }

        if(other.getClass() != this.getClass()){
            return false;
        }

        Task otherTask = (Task) other;
        if(this.name.equals(otherTask.name) && this.status.equals(otherTask.status)){
            return true;
        }

        return false;
    }
}
