package practice;
import java.util.ArrayList;

public class TodoList {
    private final ArrayList<String> todos;

    public TodoList() {
        todos = new ArrayList<>();
    }

    public void add(String todo) {
        todos.add(todo);
    }

    public void add(int index, String todo) {
        if (index >= 0 && index <= todos.size()) {
            todos.add(index, todo);
        } else {
            todos.add(todo);
        }
    }

    public void edit(int index, String todo) {
        if (index >= 0 && index <= todos.size()) {
            todos.set(index, todo);
        }
    }

    public void delete(int index) {
        if (index >= 0 && index < todos.size()) {
            todos.remove(index);
            System.out.println("Дело " + index + " удалено." );
        }
        else {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public ArrayList<String> getTodos() {
        return new ArrayList<>(todos);
    }
}