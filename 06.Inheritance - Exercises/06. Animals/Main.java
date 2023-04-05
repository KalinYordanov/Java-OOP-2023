package Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String animalType = scanner.nextLine();

        while (!animalType.equals("Beast!")) {
            String[] animalParameters = scanner.nextLine().split("\\s+");
            try {
                switch (animalType) {
                    case "Cat":
                        Cat cat = new Cat(animalParameters[0], Integer.parseInt(animalParameters[1]), animalParameters[2]);
                        System.out.println(cat.toString());
                        break;
                    case "Dog":
                        Dog dog = new Dog(animalParameters[0], Integer.parseInt(animalParameters[1]), animalParameters[2]);
                        System.out.println(dog.toString());
                        break;
                    case "Frog":
                        Frog frog = new Frog(animalParameters[0], Integer.parseInt(animalParameters[1]), animalParameters[2]);
                        System.out.println(frog.toString());
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(animalParameters[0], Integer.parseInt(animalParameters[1]));
                        System.out.println(kitten.toString());
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(animalParameters[0], Integer.parseInt(animalParameters[1]));
                        System.out.println(tomcat.toString());
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown animal: " + animalType);

                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            animalType = scanner.nextLine();
        }
    }
}
