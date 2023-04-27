package Commands;

import CollectionData.*;
import Program.*;

/**
 * Класс для вывода справки по доступным командам
 * @author Arina Nikitochkina
 */

public class Add extends Command {
    public Add() {
        this.description = "добавить новый элемент в коллекцию";
    }

    /**
     * Метод для выполнения команды Add
     */

    @Override
    public void execute() {
        Lab5.collection.add(LabWork.create());
    }
}
