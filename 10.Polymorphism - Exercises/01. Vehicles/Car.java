package Vehicles;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double liters) {
        super(fuelQuantity, liters);
    }

    @Override
    protected double getExtraFuel() {
        return 0.9;
    }
}
