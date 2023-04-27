package Commands;

import CollectionData.LabWork;
import Program.Command;
import Program.Lab5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Класс для сортировки коллекции в порядке, обратном нынешнему
 * @author Arina Nikitochkina
 */

public class Reorder extends Command {
    public Reorder() {
        this.description = "отсортировать коллекцию в порядке, обратном нынешнему";
    }

    /**
     * Метод для выполнения команды Reorder
     */

    @Override
    public void execute() {
        ArrayList<LabWork> list = new ArrayList<>();
        list.addAll(Lab5.collection);
        Collections.reverse(list);
        new Clear().execute();
        Lab5.collection.addAll(list);
    }
}
