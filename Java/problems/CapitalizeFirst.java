package Java.problems;

public class CapitalizeFirst {
    public static void main(String[] args) {
        String[] arr = {"car", "taco", "bell"};
        String[] result = capitalizeWords(arr, 0);

        for(String s : result){
            System.out.println(s);
        }
    }

    public static String[] capitalizeFirst(String[] arr, int index){

        if(index > arr.length-1) return arr;

        if(!arr[index].isEmpty()){
            String currentString = Character.toUpperCase(arr[index].charAt(0)) 
                                            + arr[index].substring(1);

            arr[index] = currentString;
        }
       
       return capitalizeFirst(arr, index+1);
    }

    public static String[] capitalizeWords(String[] arr, int index){
        if(index > arr.length - 1) return arr;

        if(!arr[index].isEmpty()){
            String currentString = arr[index].toUpperCase();
            arr[index] = currentString;
        }

        return capitalizeWords(arr, index+1);

    }
}