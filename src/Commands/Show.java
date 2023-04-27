package Commands;

import Program.*;

/**
 * Класс для вывода всех элементов коллекции в строковом представлении
 * @author Arina Nikitochkina
 */

public class Show extends Command {
    public Show() {
        this.description = "вывести все элементы коллекции в строковом представлении";
    }

    /**
     * Метод для выполнения команды Show
     */

    @Override
    public void execute() {
        if(Lab5.collection.isEmpty())
            System.out.println("Коллекция пуста");
        else
            Lab5.collection.forEach(System.out::println);
    }
}
