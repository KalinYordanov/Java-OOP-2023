package Vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double liters, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = liters;
        this.tankCapacity = tankCapacity;

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
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (this.fuelQuantity + liters > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += calculateLitersAfterLoss(liters);
    }

    protected double calculateLitersAfterLoss(double liters) {
        return liters;
    }


    public double getFuelQuantity() {
        return this.fuelQuantity;
    }
}
