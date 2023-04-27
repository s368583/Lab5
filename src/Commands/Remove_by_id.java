package Commands;

import CollectionData.*;
import Program.*;

/**
 * Класс для удаления элемента из коллекции по его id
 * @author Arina Nikitochkina
 */

public class Remove_by_id extends Command {
    public Remove_by_id() {
        this.description = "удалить элемент из коллекции по его id";
    }

    /**
     * Метод для выполнения команды Remove_by_id
     */

    @Override
    public void execute(Object arguments) {
        long id = Long.parseLong(String.valueOf(arguments));

        for(LabWork labWork : Lab5.collection)
            if(labWork.getId() == id)
                Lab5.collection.remove(labWork);

    }
}
