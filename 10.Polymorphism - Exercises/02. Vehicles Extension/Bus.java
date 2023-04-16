package Vehicles;

public class Bus extends Vehicle {
    boolean nextDriveIsEmpty;

    public Bus(double fuelQuantity, double liters, double tankCapacity) {
        super(fuelQuantity, liters, tankCapacity);
    }

    @Override
    protected double getExtraFuel() {
        if (nextDriveIsEmpty) {
            return 0;
        }
        return 1.4;
    }

    @Override
    public Double drive(double distance) {
        Double result = super.drive(distance);
        nextDriveIsEmpty = false;
        return result;
    }

    public void setupEmptyDrive() {
        nextDriveIsEmpty = true;
    }
}
