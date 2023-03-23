package SortByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPeople = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = reader.readLine().split("\\s+");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);

            Person personToAdd = new Person(firstName, lastName, age);
            people.add(personToAdd);
        }
//First - compare names , second - compare age
        Collections.sort(people, Comparator.comparing(Person::getFirstName).thenComparing(Person::getAge));

        for (Person person : people) {
            System.out.println(person.toString());
        }

    }
}
