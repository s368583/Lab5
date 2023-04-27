package Commands;

import Program.*;
import CollectionData.*;

import java.io.IOException;
import java.util.Iterator;

/**
 * Класс для удаления из коллекции всех элементов, превышающих заданный
 * @author Arina Nikitochkina
 */

public class Remove_greater extends Command {

    public Remove_greater() throws IOException {
        this.description = "удалить из коллекции все элементы, превышающие заданный";
    }

    /**
     * Метод для выполнения команды Remove_greater
     */

    @Override
    public void execute() {
        int count = 0;
        LabWork labWork2 = LabWork.create();
        Iterator<LabWork> iter = Lab5.collection.iterator();
        while(iter.hasNext()) {
            LabWork l = iter.next();
            if(l.compareTo(labWork2) > 0) {
                Lab5.collection.remove(l);
                count++;
            }
        }

        System.out.println("\nПодходящие элементы (" + count + ") были удалены");
    }
}