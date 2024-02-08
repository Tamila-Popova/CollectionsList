package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        while (true) {
            String regex = "\\d+";
            String sc = new Scanner(System.in).nextLine();
            String[] text = sc.split(" ", 3);
            switch (text[0]) {
                case "ADD" -> {
                    if (text.length <= 1) {
                        System.out.println("-");
                    } else {
                        if (text[1].matches(regex)) {
                            todoList.add(Integer.parseInt(text[1]), text[2]);
                            System.out.println("Добавлено дело " + '"' + text[2] + '"');
                        } else {
                            String sum = text[1].concat(" ").concat(text[2]);
                            System.out.println("Добавлено дело " + '"' + sum + '"');
                            todoList.add(sum);
                        }
                    }
                }
                case "LIST" -> {
                    todoList.getTodos();
                    ArrayList<String> todos = todoList.getTodos();
                    if (text.length <= 1) {
                        System.out.println("-");
                    }
                    for (int i = 0; i < todos.size(); i++) {
                        System.out.println(todos.get(i));
                    }
                }
                case "DELETE" -> {
                    int num = Integer.parseInt(text[1]);
                    int index = todoList.getTodos().size();
                    if (text.length <= 1) {
                        System.out.println("-");
                    }
                    if (text[1].matches(regex) && num >= 0 && num <= index) {
                        todoList.delete(num);
                        System.out.println("Дело " + '"' + text[2] + '"' + "удалено");
                    } else {
                        System.out.println("Дело с таким номером не существует");
                    }
                }
                case "EDIT" -> {
                    int num = Integer.parseInt(text[1]);
                    int index = todoList.getTodos().size();
                    if (text.length <= 1) {
                        System.out.println("-");
                    }
                    if (text[1].matches(regex) && num >= 0 && num < index) {
                        todoList.edit(Integer.parseInt(text[1]), text[2]);
                        System.out.println("Дело " + '"' + Integer.parseInt(text[1]) + '"' + "заменено на " + '"' + text[2] + '"');
                    }
                }
            }
        }
    }
}
