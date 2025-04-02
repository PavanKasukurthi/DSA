package Java.Java8StreamAPI;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringStreams {
    public static void main(String[] args) {
        System.out.println(firstNonRepeatedChar("aabbbszskfnmojw"));
    }

    //CHARACTER FREQUENCY
    public static void charFrequency(String str) {
        Map<Character, Long> charFrequency = str.chars()
            .mapToObj(c -> (char)c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    //FIRST REPEATED CHARACTER IN A STRING
    public static char firstFirstRepeatedChar(String str){
        Set<Character> seenCharacters = new HashSet<>();
        return  str.chars()
        .mapToObj(c -> (char)c)
        .filter(ch -> !seenCharacters.add(ch))
        .findFirst()
        .orElse('\0');
    }

    //FIRST NON REPEATED CHARACTER IN A STRING
    public static char firstNonRepeatedChar(String str){
        return str.chars()
        .mapToObj(c -> (char)c)
        .filter(c -> str.indexOf(c) == str.lastIndexOf(c))
        .findFirst()
        .orElse('\0');
    }

    //FIRST NON REPEATED CHARACTER IN A STRING USING SET
    public static char firstNonRepeatedChar2(String str){
        return str.chars()
        .mapToObj(c -> (char)c)
        .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue() == 1)
        .map(Map.Entry::getKey)
        .findFirst()
        .orElse('\0');
    }
}
