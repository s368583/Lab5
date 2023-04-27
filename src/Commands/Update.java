package Commands;

import CollectionData.*;
import Program.*;

/**
 * Класс для обновления значения элемента коллекции, id которого равен заданному
 * @author Arina Nikitochkina
 */

public class Update extends Command {
    public Update() {
        this.description = "обновить значение элемента коллекции, id которого равен заданному";
    }

    /**
     * Метод для выполнения команды Update
     */

    @Override
    public void execute(Object arguments) {
        long id = Long.parseLong(String.valueOf(arguments));
        Lab5.collection.removeIf(labWork -> labWork.getId() == id);
        LabWork labWork = LabWork.create();
        labWork.setId(id); //устанавливает labWork id
        Lab5.collection.add(labWork);
    }
}
