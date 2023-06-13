package org.example;

import org.example.bakecake.CakeRecipe;
import org.example.bakecake.MakingCake;
import org.example.todolist.ToDoList;
import org.example.todolist.UserInterfaceForTodoApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        Scanner scan = new Scanner(System.in);
        UserInterfaceForTodoApp ui = new UserInterfaceForTodoApp(list, scan);

        ui.start();






    }
}