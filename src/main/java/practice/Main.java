package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        while (true) {
            String sc = new Scanner(System.in).nextLine();
            String[] comands = sc.split("\\s", 2);
            String commandName = comands[0];
            switch (commandName.toUpperCase()) {
                case "ADD" -> {
                    if (comands.length <= 1) {
                        System.out.println("-");
                    } else {
                        System.out.println("Добавлено дело " + '"' + comands[1] + '"');
                        todoList.add(comands[1]);
                    }
                }
                case "LIST" -> {
                    todoList.getTodos();
                    ArrayList<String> todos = todoList.getTodos();
                    if (todos.size() <= 1) {
                        System.out.println("-");
                    }
                    int counter = 0;
                    for (String item : todos) {
                        System.out.println(counter + " - " + item);
                        counter++;
                    }
                }
                case "DELETE" -> {
                    if (comands.length <= 1) {
                        System.out.println("-");
                    } else {
                        int num = Integer.parseInt(comands[1]);
                        todoList.delete(num);
                    }
                }
                case "EDIT" -> {
                    String[] editParams = sc.split("\\s", 3);
                    if (editParams.length <= 1) {
                        System.out.println("-");
                    } else {
                        int num = Integer.parseInt(editParams[1]);
                        todoList.edit(num, editParams[2]);
                        System.out.println("Дело " + '"' + num + '"' + "заменено на " + '"' + editParams[2] + '"');
                    }
                }
            }
        }
    }
}
