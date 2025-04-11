package Java.Java8StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringStreams {
    public static void main(String[] args) {
        // charFrequency("askjdnjzn");
        String[] s1 = {"a", "b", "c", "d", "e"};
        String[] s2 = {"c", "d", "f", "g"};

        listDifference(s1, s2);
    }

    // CHARACTER FREQUENCY
    public static void charFrequency(String str) {
        Map<Character, Long> charFrequency = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        charFrequency.forEach((ch, count) -> System.out.println(ch + " -> " + count));
    }

    // FIRST REPEATED CHARACTER IN A STRING
    public static char firstRepeatedChar(String str) {
        Set<Character> seenCharacters = new HashSet<>();
        return str.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> !seenCharacters.add(ch))
                .findFirst()
                .orElse('\0');
    }

    // FIRST NON REPEATED CHARACTER IN A STRING
    public static char firstNonRepeatedChar(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> str.indexOf(c) == str.lastIndexOf(c))
                .findFirst()
                .orElse('\0');
    }

    // FIRST NON REPEATED CHARACTER IN A STRING USING SET
    public static char firstNonRepeatedChar2(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse('\0');
    }

    // Given two lists list1 and list2,
    // Remove elements from list1 that are also in list2
    // Remove elements from list2 that are also in list1 (original)
    public static void listDifference(String[] arr1, String[] arr2) {
        // List<String> list1 = new ArrayList<>(arr1.asList());
        Set<String> set1 = new HashSet<>(Arrays.asList(arr1));
        Set<String> set2 = new HashSet<>(Arrays.asList(arr2));

        List<String> list1 = Arrays.stream(arr1)
                .filter(e -> !set2.contains(e)).collect(Collectors.toList());

        List<String> list2 = Arrays.stream(arr2)
                .filter(e -> !set1.contains(e)).collect(Collectors.toList());

        System.out.println(list1);
        System.out.println(list2);
    }
}
