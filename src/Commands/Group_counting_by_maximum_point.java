package Commands;

import CollectionData.LabWork;
import Program.*;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Класс для группировки элементов коллекции по значению поля maximumPoint и вывода количества элементов в каждой группе
 * @author Arina Nikitochkina
 */

public class Group_counting_by_maximum_point extends Command {
    public Group_counting_by_maximum_point() {
        this.description = "сгруппировать элементы коллекции по значению поля maximumPoint, вывести количество элементов в каждой группе";
    }

    /**
     * Метод для выполнения команды Group_counting_by_maximum_point
     */

    @Override
    public void execute() {
        HashSet<Integer> pointsSet = new HashSet<>(); //здесь хранятся все возможные значения maximumPoint, это множество
        for(LabWork labWork : Lab5.collection)
            pointsSet.add(labWork.getMaximumPoint());
        ArrayList<Integer> list = new ArrayList<>(); //здесь хранятся все возможные значения maximumPoint, а это список (тут можно ходить по индексам)
        list.addAll(pointsSet);

        int[] counter = new int[pointsSet.size()];
        for(int i = 0; i < pointsSet.size(); i++)
            counter[i] = 0;
        for(int i = 0; i < pointsSet.size(); i++) {
            for(LabWork labWork : Lab5.collection)
                if(labWork.getMaximumPoint() == list.get(i))
                    counter[i]++;
        }

        String out = "Группы по значению maximumPoint:\n";
        for(int i = 0; i < list.size(); i++)
            out += ("    " + list.get(i) + " : " + counter[i] + "\n");

        System.out.println(out);
    }
}
