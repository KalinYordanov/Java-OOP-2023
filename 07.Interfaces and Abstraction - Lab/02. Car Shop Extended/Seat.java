package Car;

public class Seat extends CarImpl implements Sellable {

    private Double price;


    public Seat(String model, String color, Integer horsePower, String country ,Double price) {
        super(model,color,horsePower,country );
        this.price = price;
    }

    @Override
    public Double getPrice(){
        return price;
    }

    @Override
    public String toString() {
       StringBuilder out = new StringBuilder(super.toString());

       out.append(System.lineSeparator())
               .append(String.format("%s sells for %f", getModel(),price));

       return out.toString();

    }
}
