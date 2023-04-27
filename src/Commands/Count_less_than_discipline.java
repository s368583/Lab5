package Commands;

import CollectionData.Coordinates;
import CollectionData.Discipline;
import CollectionData.LabWork;
import Program.Command;
import Program.Lab5;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Класс для вывода количества элементов, значение поля discipline которых меньше заданного
 * @author Arina Nikitochkina
 */

public class Count_less_than_discipline extends Command {
    public Count_less_than_discipline() {
        this.description = "вывести количество элементов, значение поля discipline которых меньше заданного";
    }

    /**
     * Метод для выполнения команды Count_less_than_discipline
     */
    @Override
    public void execute() {
        Discipline.DisciplineComparator disciplineComparator = new Discipline.DisciplineComparator();

        Discipline discipline2 = Discipline.create();
        ArrayList<Discipline> list = new ArrayList<>();
        Lab5.collection.forEach(labWork -> list.add(labWork.getDiscipline()));

        int counter = 0;

        for(Discipline discipline : list)
            if(disciplineComparator.compare(discipline, discipline2) < 0)
                counter++;

        System.out.println("Элементов с полем discipline, меньшим, чем заданное: " + counter);
    }
}
