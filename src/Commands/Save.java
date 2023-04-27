package Commands;

import CollectionData.Discipline;
import CollectionData.LabWork;
import Program.*;

import com.google.gson.Gson;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Vector;

/**
 * Класс для сохранения коллекции в файл
 * @author Arina Nikitochkina
 */

public class Save extends Command {
    public PrintWriter writer = new PrintWriter(Lab5.collectionPath);
    protected PrintWriter jsonwriter = new PrintWriter("src/save.json");
    protected Gson gson = new Gson();


    public Save() throws IOException {
        this.description = "сохранить коллекцию в файл";
    }

    /**
     * Метод для выполнения команды Save
     */

    @Override
    public void execute() {

        Document doc = new Document();
        // создаем корневой элемент с пространством имен
        doc.setRootElement(new Element("Labs"));
        // формируем JDOM документ из объектов
        for (LabWork labWork : Lab5.collection) {

            Element Coords = new Element("coordinates");
            Coords.addContent(new Element("x").setText(String.valueOf(labWork.getCoordinates().getX())));
            Coords.addContent(new Element("y").setText(String.valueOf(labWork.getCoordinates().getY())));

            Element discipline = new Element("discipline");
            discipline.addContent(new Element("name").setText(String.valueOf(labWork.getDiscipline().getName())));
            discipline.addContent(new Element("lectureHours").setText(String.valueOf(labWork.getDiscipline().getLectureHours())));
            discipline.addContent(new Element("selfStudyHours").setText(String.valueOf(labWork.getDiscipline().getSelfStudyHours())));
            discipline.addContent(new Element("labsCount").setText(String.valueOf(labWork.getDiscipline().getLabsCount())));

            Element lab = new Element("Lab");
            lab.setAttribute("id", String.valueOf(labWork.getId()));
            lab.addContent(new Element("name").setText(labWork.getName()));
            lab.addContent(Coords);
            lab.addContent(new Element("minimalPoint").setText(String.valueOf(labWork.getMinimalPoint())));
            lab.addContent(new Element("maximumPoint").setText(String.valueOf(labWork.getMaximumPoint())));
            lab.addContent(new Element("averagePoint").setText(String.valueOf(labWork.getAveragePoint())));
            lab.addContent(new Element("difficulty").setText(String.valueOf(labWork.getDifficulty())));
            lab.addContent(discipline);

            doc.getRootElement().addContent(lab);
        }

        XMLOutputter xmlWriter = new XMLOutputter(Format.getPrettyFormat());
        // сохнаряем в файл

        try {
            xmlWriter.output(doc, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        jsonwriter.write(gson.toJson(Lab5.collection));
//        jsonwriter.flush();
    }
}
