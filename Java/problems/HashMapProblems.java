package Java.problems;

import java.util.*;
import java.util.stream.*;

public class HashMapProblems {
    public static void main(String[] args) {
        // convertingMapToList();
        // classAsKey();
        sortMapBasedOnValues();
    }

    public static void convertingMapToList() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        // Converting HashMap to ArrayList
        List<Map.Entry<Integer, String>> entryList = new ArrayList<>(map.entrySet());

        // Convert Keys to ArrayList
        List<Integer> keyList = new ArrayList<>(map.keySet());

        // Convert Values to ArrayList
        List<String> valueList = new ArrayList<>(map.values());

        for (Map.Entry<Integer, String> entry : entryList) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    // Custom Class as a Key in HashMap
    public static void classAsKey() {
        Map<Employee, String> map = new HashMap<>();

        Employee e1 = new Employee(1, "Bruce Wayne");
        Employee e2 = new Employee(2, "Clark Kent");

        map.put(e1, "Batman");
        map.put(e2, "Superman");

        for (Map.Entry<Employee, String> entry : map.entrySet()) {
            System.out.println(
                    entry.getKey().getName() + " -> " + entry.getValue());
        }
    }

    static class Employee {
        private int id;
        private String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    // Sort HashMap based on values
    public static void sortMapBasedOnValues() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Banana", 3);
        map.put("Apple", 5);
        map.put("Orange", 1);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue());

        Map<String, Integer> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Map<String, Integer> sortedMapUsingStreams = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(sortedMapUsingStreams);
    }
}
