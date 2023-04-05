package Car;

public class Seat implements Car {

    private String model;
    private String color;
    private Integer hp;
    private String country;

    public Seat(String model, String color, int hp, String country) {
        this.model = model;
        this.color = color;
        this.hp = hp;
        this.country = country;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return hp;
    }

    @Override
    public String getCountryProduced() {
        return country;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires" , getModel() , getCountryProduced() ,Car.TIRES);
    }
}
