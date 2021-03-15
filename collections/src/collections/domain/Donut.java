package collections.domain;

public class Donut implements Comparable<Donut> {

    private final String filling;

    public Donut(String filling) {
        this.filling = filling;
    }

    @Override
    public String toString() {
        return "Donut{" +
                "filling='" + filling + '\'' +
                '}';
    }

    @Override
    public int compareTo(Donut o) {
        return filling.compareTo(o.filling);
    }
}
