package Commands;

import Program.*;

/**
 * Класс для очистки коллекции
 * @author Arina Nikitochkina
 */
public class Clear extends Command {
    public Clear() {
        this.description = "очистить коллекцию";
    }

    /**
     * Метод для выполнения команды Clear
     */
    @Override
    public void execute() {
        Lab5.collection.clear();
    }
}
