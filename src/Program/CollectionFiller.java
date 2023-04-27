package Program;

import CollectionData.LabList;
import CollectionData.LabWork;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс для файла и заполнения его данных в коллекцию
 * @author Arina Nikitochkina
 */
public class CollectionFiller extends Command {
    //protected Scanner scanner = new Scanner(new File("src/save.json"));
    //protected Gson gson = new Gson();

    /**
     * Метод для учета возможной ошибки по ходу чтения файла
     * @throws FileNotFoundException
     */
    public CollectionFiller() throws FileNotFoundException {}

    /**
     * Метод для заполнения коллекции из файла
     */
    @Override
    public void execute() {

        JAXBContext jaxbContext = null;
        try {
            CollectionDeque deque =  new CollectionDeque();
            jaxbContext = JAXBContext.newInstance(LabList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            LabList labs = (LabList) jaxbUnmarshaller.unmarshal(new File("src/collection.xml"));
            for (LabWork labWork : labs.getLabs()) {
                labWork.setCreationDate(LocalDateTime.now());
                System.out.println(labWork.toString());
                deque.add(labWork);
            }
            Lab5.setCollection(deque);

        } catch (JAXBException e) {
            System.out.println("Файл пустой");
        }




    }
}
