package Program;

import CollectionData.LabWork;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * Класс для выполнения команд, записи коллекции, чтения скрипта
 * Главный класс
 * @author Arina Nikitochkina
 */


public class Lab5 {

    public static CollectionDeque collection = new CollectionDeque();


    public static void setCollection(CollectionDeque collection) {
        Lab5.collection = collection;
    }

    /** Имя файла коллекции */
    public static String collectionPath = "src/collection.xml";

    /** Имя файла скрипта     */
    public static String scriptPath = "";

    /** Очередь из команд     */
    public static Queue<String> scriptLines = new LinkedList<String>() {
    };

    /** script для того, чтобы при чтении скрипта он не перескакивал на консоль и до конца прочитал и понял скрипт   */
    public static boolean script = false;

    public static void main(String[] args) throws Exception {
        String fileName = "";

        if(args.length==1) {
            fileName = args[0];
        }
        else {
            if(args.length>0) {
                System.out.println("Ошибка аргумента. Буду использвать collection.xml");
            }
            fileName="src/collection.xml";
        }

        System.out.printf("Имя файла: %s\n", fileName);

        File f = new File(fileName);
        if (f.isFile() && f.canRead()) {
            System.out.println("файл существует");
        } else {
            fileName = "src/collection.xml";
            System.out.println("Такого файла не существует, буду использвать src/collection.xml");
        }

        CollectionFiller collectionFiller = new CollectionFiller();
        collectionFiller.setFilePath(fileName);
        collectionFiller.execute();
        ConsoleCommandReader.start();


    }
}