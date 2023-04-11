package BirthdayCelebrations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BirthdayCelebrationsHandler handler = new BirthdayCelebrationsHandler("End");

        handler.readAndHandleCommandsToEnd(scanner);

        String birthYear = scanner.nextLine();

        for (Birthable b : handler.getAllBirthable()) {
            if (b.getBirthDate().endsWith(birthYear)) {
                System.out.println(b.getBirthDate());
            }
        }


    }
}
