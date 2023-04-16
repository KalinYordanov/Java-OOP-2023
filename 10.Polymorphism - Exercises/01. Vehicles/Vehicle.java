package Vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double liters) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = liters;

    }


    public Double drive(double distance) {
        double fuelRequired = distance * (fuelConsumption + getExtraFuel());
        if (fuelRequired > fuelQuantity) {
            return null;
        }
        fuelQuantity -= fuelRequired;
        return distance;
    }

    protected abstract double getExtraFuel();

    public void refuel(double liters) {
        this.fuelQuantity += calculateLitersAfterLoss(liters);
    }

    protected double calculateLitersAfterLoss(double liters) {
        return liters;
    }


    public double getFuelQuantity() {
        return this.fuelQuantity;
    }
}
