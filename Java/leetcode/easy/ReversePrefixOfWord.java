package Java.leetcode.easy;

public class ReversePrefixOfWord {
    public static void main(String[] args) {
        System.out.println(reversePrefixOfWord("abcdefd", 'd'));
    }
    
    public static String reversePrefixOfWord(String word, char ch){
        int firstOccurence = word.indexOf(ch);

        if(firstOccurence == -1) return word;

        StringBuilder strRev = new StringBuilder(word.substring(0, firstOccurence + 1)).reverse();

        if(firstOccurence < word.length()){
            strRev.append(word.substring(firstOccurence, word.length()));
        }

        return strRev.toString();
    }
}
