package Commands;

import Program.*;

/**
 * Класс для вывода информации о коллекции
 * @author Arina Nikitochkina
 */

public class Info extends Command {
    public Info() {
        this.description = "вывести информацию о коллекции";
    }

    /**
     * Метод для выполнения команды Info
     */

    @Override
    public void execute() {
        Lab5.collection.info();
    }
}
