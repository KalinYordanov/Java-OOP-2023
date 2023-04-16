package Vehicles;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double liters , double tankCapacity) {
        super(fuelQuantity, liters , tankCapacity);
    }

    @Override
    protected double getExtraFuel() {
        return 0.9;
    }
}
