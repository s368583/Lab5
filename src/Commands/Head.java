package Commands;

import Program.*;

/**
 * Класс для вывода первого элемента коллекции
 * @author Arina Nikitochkina
 */

public class Head extends Command {
    public Head() {
        this.description = "вывести первый элемент коллекции";
    }

    /**
     * Метод для выполнения команды Head
     */

    @Override
    public void execute() {
        Lab5.collection.head();
    }
}
