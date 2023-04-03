package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people;
        List<Product> products;
        try {
            people = parsePeople(scanner.nextLine());
            products = parseProducts(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String action = scanner.nextLine();
        while (!action.equals("END")) {
            String[] personAndProduct = action.split("\\s+");
            Person person = people.stream().filter(p -> p.getName().equals(personAndProduct[0])).findFirst().get();
            Product product = products.stream().filter(p -> p.getName().equals(personAndProduct[1])).findFirst().get();

            try {
                person.buyProduct(product);
                System.out.println(person.getName() + " bought " + product.getName());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            action = scanner.nextLine();
        }

        for (Person person : people) {
            List<Product> personProducts = person.getProducts();
            System.out.print(person.getName() + " - ");
            if (personProducts.isEmpty()) {
                System.out.println("Noting bought");
            } else {
                List<String> productName = personProducts
                        .stream()
                        .map(Product::getName)
                        .collect(Collectors.toList());
                System.out.println(String.join(", ", productName));
            }
        }

    }

    private static List<Product> parseProducts(String productsString) {
        List<Product> products = new ArrayList<>();
        String[] peopleAssString = productsString.split(";");
        for (String personAsString : peopleAssString) {
            String[] nameAndCost = personAsString.split("=");
            products.add(new Product(nameAndCost[0], Double.parseDouble(nameAndCost[1])));
        }


        return products;
    }

    private static List<Person> parsePeople(String peopleString) {
        List<Person> people = new ArrayList<>();
        String[] peopleAssString = peopleString.split(";");
        for (String personAsString : peopleAssString) {
            String[] nameAndMoney = personAsString.split("=");
            people.add(new Person(nameAndMoney[0], Double.parseDouble(nameAndMoney[1])));
        }
        return people;
    }
}
