package collections.domain;

public class Pizza {

    private final String topping;
    private final String name;

    public Pizza(String topping) {
        this(topping, "");
    }

    public Pizza(String topping, String name) {
        this.topping = topping;
        this.name = name;
    }

    public Pizza withTopping(String topping) {
        Pizza pizza = new Pizza(topping, this.name);
        return pizza;
    }
}
