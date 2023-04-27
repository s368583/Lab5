package Commands;

import Program.*;

import java.io.IOException;

/**
 * Класс для удаления первого элемента из коллекции
 * @author Arina Nikitochkina
 */

public class Remove_first extends Command {
    public Remove_first() {
        this.description = "удалить первый элемент из коллекции";
    }

    /**
     * Метод для выполнения команды Remove_first
     */

    @Override
    public void execute() {
        Lab5.collection.removeFirst();
    }
}