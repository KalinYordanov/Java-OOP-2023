package Animals;

public abstract class Animal {
    private String name;
    private String favoriteFood;

    protected Animal(String name, String favoriteFood) {
        this.name = name;
        this.favoriteFood = favoriteFood;
    }

    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s", name, favoriteFood);
    }

}
