package collections;

import collections.domain.Donut;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        Set<Donut> donuts = new TreeSet<>();
        donuts.add(new Donut("chocolate"));
        donuts.add(new Donut("chocolate"));
        donuts.add(new Donut("vanilla"));
        donuts.add(new Donut("caramel"));
        System.out.println(donuts);
    }

    private static void withPrimitives() {
        Set<Integer> numbers = new TreeSet(Set.of(3, -3, 0, 5));
        System.out.println(numbers);
    }
}
