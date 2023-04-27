package Program;

import java.util.Scanner;
/**
 * Класс для чтения команд из консоли
 * @author Arina Nikitochkina
 */
public class ConsoleCommandReader {
    public ConsoleCommandReader() {}

    /**
     * Метод для чтения команд из консоли
     * @throws Exception
     */
    public static void start() throws Exception {
        Lab5.script = false;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Для просмотра доступных команд введите help");
            System.out.println("Введите команду:");

            String consoleLine = scanner.nextLine();

            if(consoleLine.isEmpty()) {
                continue;
            }
            if(consoleLine.contains(" ")) {
                String[] consoleInput = consoleLine.split(" ");
                String commandLine = consoleInput[0].substring(0, 1).toUpperCase() + consoleInput[0].substring(1);
                String argumentLine = consoleInput[1];

                try {
                    Class commandClass = Class.forName("Commands." + commandLine);
                    Command command = (Command) commandClass.newInstance();
                    command.execute(argumentLine);
                } catch (ClassNotFoundException e) {
                    System.out.println("Команда не найдена");
                }
            }
            else {
                String commandLine = consoleLine.substring(0, 1).toUpperCase() + consoleLine.substring(1);

                try {
                    Class commandClass = Class.forName("Commands." + commandLine);
                    Command command = (Command) commandClass.newInstance();
                    command.execute();
                } catch (ClassNotFoundException e) {
                    System.out.println("Команда не найдена");
                }
            }
        }
    }
}
