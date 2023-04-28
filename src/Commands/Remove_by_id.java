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
        try {
            long id = Long.parseLong(String.valueOf(arguments));
            String str = Long.toString(id);
            if(isNumeric(str)){
                for(LabWork labWork : Lab5.collection)
                    if(labWork.getId() == id)
                        Lab5.collection.remove(labWork);
                }

        } catch(Exception e) {
            System.out.println("\nДанные введены неверно");
            System.out.print("Введите название работы: ");
        }

    }

    /**
     * Проверка на то, является ли аргумент числом
     * @param str
     * @return boolean
     */
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
