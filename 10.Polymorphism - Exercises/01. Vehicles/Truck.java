package Vehicles;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double liters) {
        super(fuelQuantity, liters);
    }

    @Override
    protected double calculateLitersAfterLoss(double liters) {
        return liters * 0.95;
    }

    @Override
    protected double getExtraFuel() {
        return 1.6;
    }
}
