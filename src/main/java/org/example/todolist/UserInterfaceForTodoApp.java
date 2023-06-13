package org.example.todolist;

import org.example.takeout.Customer;
import org.example.takeout.TakeOutApp;
import org.example.working.DoSomeWork;
import org.example.reading.ReadingABook;
import org.example.bakecake.MakingCake;

import java.util.Scanner;

public class UserInterfaceForTodoApp {
    private ToDoList todoList;
    private Scanner scan;
    private MakingCake cakeBaker;
    private Customer person;
    private TakeOutApp takeOutApp;

    public UserInterfaceForTodoApp(ToDoList list, Scanner scan) {
        this.todoList = list;
        this.scan = scan;
        this.cakeBaker = new MakingCake();

    }

    public void start() {

        System.out.print("Please input you name: ");
        String username = scan.nextLine();
        System.out.println("Hello, " + username + "! Let's get started with the day. First, let's see what you have " +
                "to do for today.");
        person = new Customer(username, 500);
        this.takeOutApp = new TakeOutApp(person);

        while (true) {
            System.out.print("What would you like to do? Choose one of the following commands: add, list, done, " +
                    "remove, save, open, choose task to do, sort priority, default sort or stop. \nCommand: ");
            String command = scan.nextLine();
            if (command.equals("stop")) {
                break;
            }

            if (command.equals("add")) {
                addTask();
            }

            if (command.equals("list")) {
                listTasks();
            }

            if (command.equals("done")) {
                markAsDone();
            }

            if (command.equals("remove")) {
                removeTask();
            }

            if (command.equals("save")) {
                saveTasks();
            }

            if (command.equals("open")) {
                openTaskFile();
            }

            if (command.equals("sort priority")) {
                sortByPriority();
            }

            if (command.equals("default sort")) {
                defaultSort();
            }

            if (command.equals("choose task to do")) {
                chooseTask();
            }
        }

    }

    public void addTask() {
        while (true) {
            System.out.print("Please insert the name of the task followed by comma and by its priority (none," +
                    " low or high); e.g., walk the dog,low: ");
            String line = scan.nextLine();
            if (!line.isBlank()) {
                String[] parts = sanitize(line);
                Task task = new Task(parts[0], parts[1]);
                todoList.addTask(task);
                System.out.println("Task successfully added.");
                break;
            } else {
                System.out.println("Wrong format of task to add...");
            }
        }
    }

    public void listTasks() {
        if (todoList.getTodoList().isEmpty()) {
            System.out.println("There is nothing to do!");
        } else {
            System.out.println("Here is the todo list for today: ");
            this.todoList.print();
        }
    }

    public void markAsDone() {
        System.out.print("Which task number is to be marked as completed? ");
        int number = Integer.valueOf(scan.nextLine());
        todoList.markAsDone(number);
        System.out.println("Task " + number + " marked as completed.");
    }

    public void removeTask() {
        System.out.print("Which task number is to be removed? ");
        int number = Integer.valueOf(scan.nextLine());
        int val = todoList.removeByNumber(number);
        if (val == -1) {
            System.out.println("Task number does not exist.");
        } else {
            System.out.println("Task " + number + " successfully removed.");
        }
    }

    public void saveTasks() {
        todoList.saveToFile();
    }

    public void openTaskFile() {
        todoList.readFromFile();
        System.out.println("Tasks successfully added to the current list.");
    }

    public void sortByPriority() {
        todoList.sortByPriorityThenStatus();
    }

    public void defaultSort() {
        todoList.defaultSort();
    }

    public void chooseTask() {
        System.out.print("Which task? - input name: ");
        String input = scan.nextLine();
        if (input.contains("bake") && input.contains("cake")) {
            System.out.println("Let's start making a cake!");
            cakeBaker.start();
            System.out.println("");
        } else if (input.startsWith("work")) {
            System.out.println(DoSomeWork.work());
            System.out.println("");
        } else if (input.startsWith("read")) {
            ReadingABook.printBooks();
            System.out.print("Select a number from the list: ");
            int num = Integer.valueOf(scan.nextLine());
            System.out.print("You chose: ");
            readBook(num);
            System.out.println("After reading a few pages, you fell asleep.");
            System.out.println("");
        } else if (input.contains("take-out")) {
            System.out.println("Hello, " + person.getName() + ". Your current sold is " + person.getWallet());
            System.out.print("Would you like to recharge your wallet? (y/n): ");
            String answer = scan.nextLine();
            if (answer.toLowerCase().equals("y")) {
                System.out.print("How much money? ");
                double money = Double.valueOf(scan.nextLine());
                person.increaseWallet(money);
                System.out.println("Your wallet is now: " + person.getWallet());
            }
            System.out.println("Here is the list of restaurants!");
            takeOutApp.displayRestaurants();
            System.out.print("Choose a restaurant: ");
            int selection = Integer.valueOf(scan.nextLine());
            System.out.println("Today's Menu Options! (select number from list or 0 to checkout)");
            System.out.println();
            System.out.println(takeOutApp.restaurantMenu(selection));
            while (true) {
                System.out.print("Choose a menu item: ");
                String line = scan.nextLine();
                while(!isNumeric(line)){
                    System.out.print("Please insert a number from the list. Choose a menu item: ");
                    line = scan.nextLine();
                }

                int num = Integer.valueOf(line);
                if (num == 0) {
                    break;
                }
                takeOutApp.shop(num);
            }
            takeOutApp.finalizeOrder();
            System.out.println("");
        }
    }

    private boolean isNumeric(String str) {
       return str.matches("\\d+");
    }

    private void readBook(int num) {
        int index = num - 1;
        if (index < 0 && index >= ReadingABook.getSize()) {
            return;
        }
        System.out.println(ReadingABook.getList().get(index));
    }

    private String[] sanitize(String str) {
        String[] parts = str.split(",");
        parts[0] = parts[0].trim();
        parts[1] = parts[1].trim();
        return parts;
    }
}
