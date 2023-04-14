package FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Buyer> buyerByName = new HashMap<>();
        int numPeople = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numPeople; i++) {
            String paramsString = scanner.nextLine();
            String[] personParams = paramsString.split("\\s+");
            switch (personParams.length) {
                case 3:
                    Rebel rebel = new Rebel(personParams[0], Integer.parseInt(personParams[1]), personParams[2]);
                    buyerByName.put(rebel.getName(), rebel);
                    break;
                case 4:
                    Citizen citizen = new Citizen(personParams[0], Integer.parseInt(personParams[1]), personParams[2], personParams[3]);
                    buyerByName.put(citizen.getName(), citizen);
                    break;
                default:
                    throw new IllegalStateException("Unknown input: " + paramsString);
            }
        }

        String nameFromConsole = scanner.nextLine();
        while (!"End".equals(nameFromConsole)) {
            Buyer buyer = buyerByName.get(nameFromConsole);
            if (buyer != null) {
                buyer.buyFood();
            }
            nameFromConsole = scanner.nextLine();
        }
        int totalFood = buyerByName.values()
                .stream()
                .mapToInt(Buyer::getFood)
                .sum();

        System.out.println(totalFood);


    }
}
