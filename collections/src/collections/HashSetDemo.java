package collections;

import collections.domain.Pizza;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

    public static void main(String[] args) {
        Set<Pizza> pizzas = new HashSet<>();
        Pizza tomatensauce = new Pizza("Tomatensauce");
        pizzas.add(tomatensauce);
        pizzas.add(tomatensauce);
        pizzas.add(tomatensauce);
        pizzas.add(new Pizza("Tomatensauce"));
        pizzas.add(new Pizza("Käse"));
        System.out.println(pizzas);
    }
}
