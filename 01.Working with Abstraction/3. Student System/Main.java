package StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CommandExecutor executor = new CommandExecutor();
        while (true) {
            String[] input = scanner.nextLine().split(" ");

            if (CommandExecutor.isExitCommand(input[0])) {
                break;
            }

            //FIXME: Remove command name from data arrey
            executor.executeCommand(input[0], input);

        }
    }
}
