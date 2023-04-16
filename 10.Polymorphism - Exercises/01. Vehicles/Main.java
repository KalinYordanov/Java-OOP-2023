package Vehicles;


import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

    public static final String CAR_NAME = "Car";
    public static final String TRUCK_NAME = "Truck";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DecimalFormat format = new DecimalFormat("###.##");

        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");

        Map<String, Vehicle> vehicleByName = new LinkedHashMap<>();

        vehicleByName.put(CAR_NAME, new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2])));
        vehicleByName.put(TRUCK_NAME, new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2])));

        int numCom = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numCom; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String operation = commandParts[0];
            String vehicleName = commandParts[1];
            Vehicle vehicle = vehicleByName.get(vehicleName);

            switch (operation) {
                case "Drive":
                    Double travelledKm = vehicle.drive(Double.parseDouble(commandParts[2]));
                    if (travelledKm != null) {
                        System.out.println(vehicleName + " travelled " + format.format(travelledKm) + " km");
                    } else {
                        System.out.println(vehicleName + " needs refueling");
                    }
                    break;
                case "Refuel":
                    vehicle.refuel(Double.parseDouble(commandParts[2]));
                    break;
                default:
                    throw new IllegalStateException("Unknown command " + commandParts[0]);
            }
        }
        System.out.println("Car: " + String.format("%.2f",vehicleByName.get(CAR_NAME).getFuelQuantity()));
        System.out.println("Truck: " + String.format("%.2f",vehicleByName.get(TRUCK_NAME).getFuelQuantity()));

    }
}
