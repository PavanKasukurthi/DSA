package Java.Java8StreamAPI;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class StringStreams {
    public static void main(String[] args) {
        // charFrequency("askjdnjzn");
        String[] s1 = { "a", "b", "c", "d", "e" };
        String[] s2 = { "c", "d", "f", "g" };

        // listDifference(s1, s2);

        // List<String> words = Arrays.asList("testing", "java", "streams");
        // System.out.println(containsSpecificSubstring("test", words));

        // printStringCombinations("abc");

        List<String> names = Arrays.asList("Clark Kent", "Bruce Wayne", "Hal Jordan");
        // lastNameSort(names);
        // groupStringsBasedOnLengths(words);
        String sentence = "Java! is great, and Java is powerful. #Java";
        // wordFrequency((sentence));
        // mostRepeatingCharacter("adkbxzcnmbmznbfjabznxcmbakshgdhkzbxcbalkdhsl");
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple", "kiwi", "kiwi",
                "kiwi", "kiwi");

        // System.out.println(topNRepeatedWords(words, 3));

        List<String> sentences = Arrays.asList(
                "Java streams are powerful",
                "Streams help process collections",
                "Java supports functional programming",
                "Functional programming makes code concise",
                "Streams can filter map and reduce data",
                "Java is platform independent",
                "Code once run anywhere",
                "Collections and streams work well together",
                "Java developers love streams",
                "Practice makes you better at Java");

        System.out.println(mostCommonWord(sentences));
    }

    // CHARACTER FREQUENCY
    public static void charFrequency(String str) {
        Map<Character, Long> charFrequency = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        charFrequency.forEach((ch, count) -> System.out.println(ch + " -> " + count));
    }

    // WORD FREQUENCY IN A SENTENCE
    public static void wordFrequency(String sentence) {
        Map<String, Long> wordFreq = Arrays.stream(sentence.replaceAll("[^a-zA-z\\s]", "").split("\\s+"))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(wordFreq);
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
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse('\0');
    }

    // MOST REPEATED CHARACTER IN A STRING
    public static void mostRepeatingCharacter(String str) {
        Optional<Map.Entry<Character, Long>> result = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        result.ifPresent(System.out::println);
    }

    // TOP N REPEATED WORDS IN A LIST OF STRINGS
    public static List<String> topNRepeatedWords(List<String> words, int n) {
        return words.stream()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .limit(n)
                .collect(Collectors.toList());
    }

    // MOST COMMON WORD IN A LIST OF SENTENCES
    public static String mostCommonWord(List<String> sentences) {
        return sentences.stream()
                .flatMap(str -> Arrays.stream(str.toLowerCase().replaceAll("[^a-zA-z\\s+]", "\\s").split(" ")))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
    }

    // Given two lists list1 and list2,
    // Remove elements from list1 that are also in list2
    // Remove elements from list2 that are also in list1 (original)
    public static void listDifference(String[] arr1, String[] arr2) {
        List<String> list1 = Arrays.stream(arr1).toList();
        List<String> list2 = Arrays.stream(arr2).toList();

        List<String> result1 = list1.stream().filter(c -> !list2.contains(c)).collect(Collectors.toList());
        List<String> result2 = list2.stream().filter(c -> !list1.contains(c)).collect(Collectors.toList());

        System.out.println(result1);
        System.out.println(result2);
    }

    // ANY STRING IN A LIST CONTAINS A SPECIFIC SUBSTRING
    public static boolean containsSpecificSubstring(String str, List<String> stringList) {

        return stringList.stream().anyMatch(e -> e.contains(str));
    }

    // STRING COMBINATIONS USING JAVA STREAMS
    public static Stream<String> stringCombinations(String str) {
        if (str.isEmpty())
            return Stream.of("");

        char first = str.charAt(0);
        String rest = str.substring(1);

        return stringCombinations(rest).flatMap(s -> Stream.of(s, first + s));
    }

    public static void printStringCombinations(String str) {
        List<String> allCombinations = stringCombinations(str).collect(Collectors.toList());

        allCombinations.forEach(System.out::println);
    }

    // STRING PERMUTATIONS USING JAVA STREAMS
    public static List<String> stringPermutations(String str) {
        if (str.length() == 1) {
            return List.of(str);
        }

        return IntStream.range(0, str.length())
                .boxed()
                .flatMap(i -> {
                    char ch = str.charAt(i);
                    String remaining = str.substring(0, i) + str.substring(i + 1);
                    return stringPermutations(remaining).stream().map(s -> ch + s);
                })
                .collect(Collectors.toList());
    }

    // SORT NAMES BASED ON LAST NAME
    public static void lastNameSort(List<String> names) {

        List<String> result = names.stream().sorted(Comparator.comparing(name -> name.split(" ")[1]))
                .collect(Collectors.toList());

        System.out.println(result);
    }

    // Common elements of two lists
    public static void commonElementsOfLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> commonElements = list1.stream()
                .filter(list2::contains)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(commonElements);
    }

    // Grouping Strings as lists based on their lengths
    public static void groupStringsBasedOnLengths(List<String> list) {
        Map<Integer, ArrayList<String>> map = list.stream().collect(Collectors.groupingBy(
                String::length,
                Collectors.toCollection(ArrayList::new)));

        map.forEach((length, groupList) -> System.out.println(length + " -> " + groupList));
    }
}