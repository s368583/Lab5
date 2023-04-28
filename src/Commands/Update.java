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
        try {
            long id = Long.parseLong(String.valueOf(arguments));
            String str = Long.toString(id);
            if(isNumeric(str)){
                Lab5.collection.removeIf(labWork -> labWork.getId() == id);
                LabWork labWork = LabWork.create();
                labWork.setId(id); //устанавливает labWork id
                Lab5.collection.add(labWork);
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
