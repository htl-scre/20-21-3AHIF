package collections;

import java.util.*;

public class MapDemo {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        String ret = map.put(0, "Null");
        ret = map.put(1, "Eins");
        ret = map.put(2, "Zwei");

        ret = map.put(0, "Neu");
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            String value = map.get(key);
            System.out.println(key + ", " + value);
        }
        System.out.println("-------------");
        for (String value : map.values()) {
            int key = getKeyForValue(map, value);
            System.out.println(key + ", " + value);
        }
        System.out.println("-------------");
        for (var entry : map.entrySet()) {
            System.out.println(entry);
        }
    }

    private static Integer getKeyForValue(Map<Integer, String> map, String value) {
        for (Integer key : map.keySet()) {
            if (map.get(key).equals(value)) {
                return key;
            }
        }
        return null;
    }
}
