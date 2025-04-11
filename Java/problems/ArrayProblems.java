package Java.problems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayProblems {

    public static void main(String[] args) {
        int[] a = { 3, 9, 2, 3, 1, 7, 2, 3, 5 };
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        // System.out.println(Arrays.toString(removeAllOccurrencesOfAnElementInAnArray(a,
        // k)));
        // System.out.println(secondLargestElementInAnArrayStreamsWithoutSorting(a));
        // System.out.println(Arrays.toString(elementsByFrequency(nums)));
        // rotateArray(nums, k);
        // System.out.println(Arrays.toString(nums));

        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 3, 4, 6, 7, 9, 11 };
        listDifference(arr1, arr2);
    }

    /* REMOVE ALL OCCURENCES OF AN ELEMENT IN AN ARRAY */
    public static int[] removeAllOccurrencesOfAnElementInAnArray(int[] arr, int n) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != n) {
                arr[index++] = arr[i];
            }
        }

        return Arrays.copyOf(arr, index);
    }

    /* SECOND LARGEST ELEMENT IN AN ARRAY WITHOUT SORTING */
    public static int secondLargestElementInAnArray(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max2 && arr[i] != max) {
                max2 = arr[i];
            }
        }

        return max2;
    }

    /* SECOND LARGEST ELEMENT IN AN ARRAY USING STREAMS */
    public static int secondLargestElementInAnArrayStreamsWithSorting(int[] arr) {
        return Arrays.stream(arr).distinct().boxed().sorted((a, b) -> b - a).skip(1).findFirst()
                .orElse(Integer.MIN_VALUE);
    }

    /* SECOND LARGEST ELEMENT IN AN ARRAY WITHOUT SORTING USING STREAMS */
    public static int secondLargestElementInAnArrayStreamsWithoutSorting(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();

        return Arrays.stream(arr).filter(x -> x != max).max().getAsInt();
    }

    /* MAXIMUM NUMBER OF CONSECUTIVE 1s OR 0s */
    public static int maxConsecutiveCount(int[] arr) {
        if (arr.length == 0)
            return 0;

        int maxCount = 0, count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        return Math.max(maxCount, count);
    }

    /* ROTATE ARRAY */
    public static void rotateArray(int[] nums, int k) {
        k = k % nums.length;
        System.out.println(k);
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    /* REARRANGE POSITIVE AND NEGATIVE NUMBERS IN ALTERNATE FASHION */
    public static ArrayList<Integer> rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i : arr) {
            if (i < 0)
                neg.add(i);
            else
                pos.add(i);
        }

        int a = 0, b = 0, k = 0;
        while (a < pos.size() && b < neg.size()) {
            if (k % 2 == 0)
                arr.set(k++, pos.get(a++));
            else
                arr.set(k++, neg.get(b++));
        }

        while (a < pos.size())
            arr.set(k++, pos.get(a++));
        while (b < neg.size())
            arr.set(k++, neg.get(b++));

        return arr;
    }

    /*
     * REARRANGE POSITIVE AND NEGATIVE NUMBERS IN ALTERNATE FASHION USING JAVA
     * STREAMS
     */
    public static ArrayList<Integer> rearrangeStreams(ArrayList<Integer> arr) {
        List<Integer> pos = arr.stream().filter(x -> x >= 0).collect(Collectors.toList());
        List<Integer> neg = arr.stream().filter(x -> x < 0).collect(Collectors.toList());

        ArrayList<Integer> result = new ArrayList<>();

        IntStream.range(0, Math.max(pos.size(), neg.size()))
                .forEach(i -> {
                    if (i < pos.size())
                        result.add(pos.get(i));
                    if (i < neg.size())
                        result.add(neg.get(i));
                });

        return result;
    }

    /* SORT ELEMENTS BY FREQUENCY */
    public static int[] elementsByFrequency(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        Integer[] ints = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ints[i] = nums[i];
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        }

        Arrays.sort(ints, (a, b) -> {
            int freqA = counts.get(a);
            int freqB = counts.get(b);
            if (freqA == freqB) {
                return b - a;
            } else {
                return freqA - freqB;
            }
        });

        int[] result = new int[nums.length];

        for (int i = 0; i < ints.length; i++) {
            result[i] = ints[i];
        }

        return result;
    }

    /* SORT ELEMENTS BY FREQUENCY USING STREAMS */
    public static int[] elementsByFrequencyUsingStreams(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());

        list.sort((a, b) -> {
            int freqCompare = map.get(a).compareTo(map.get(b));
            if (freqCompare == 0)
                return b.compareTo(a);
            else
                return freqCompare;
        });

        return list.stream().mapToInt(x -> x).toArray();
    }

    // Given two lists list1 and list2,
    // Remove elements from list1 that are also in list2
    // Remove elements from list2 that are also in list1 (original)
    public static void listDifference(int[] arr1, int[] arr2) {
        List<Integer> list1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());

        List<Integer> result1 = list1.stream().filter(e -> !list2.contains(e)).collect((Collectors.toList()));
        List<Integer> result2 = list2.stream().filter(e -> !list1.contains(e)).collect((Collectors.toList()));

        System.out.println(result1);
        System.out.println(result2);
    }
}
