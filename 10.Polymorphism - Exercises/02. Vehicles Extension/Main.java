package Vehicles;


import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

    public static final String CAR_NAME = "Car";
    public static final String TRUCK_NAME = "Truck";
    public static final String BUS_NAME = "Bus";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DecimalFormat format = new DecimalFormat("###.##");

        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");
        String[] busInfo = scanner.nextLine().split("\\s+");

        Map<String, Vehicle> vehicleByName = new LinkedHashMap<>();

        vehicleByName.put(CAR_NAME,
                new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3])));
        vehicleByName.put(TRUCK_NAME,
                new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3])));
        vehicleByName.put(BUS_NAME,
                new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3])));

        int numCom = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numCom; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String operation = commandParts[0];
            String vehicleName = commandParts[1];
            Vehicle vehicle = vehicleByName.get(vehicleName);

            try {
                switch (operation) {
                    case "DriveEmpty":
                        Bus bus = (Bus) vehicleByName.get(BUS_NAME);
                        bus.setupEmptyDrive();
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
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Car: " + String.format("%.2f", vehicleByName.get(CAR_NAME).getFuelQuantity()));
        System.out.println("Truck: " + String.format("%.2f", vehicleByName.get(TRUCK_NAME).getFuelQuantity()));
        System.out.println("Bus: " + String.format("%.2f", vehicleByName.get(BUS_NAME).getFuelQuantity()));

    }
}
