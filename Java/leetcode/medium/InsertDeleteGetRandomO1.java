package Java.leetcode.medium;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class InsertDeleteGetRandomO1 {

    HashSet<Integer> set;
    Random random;

    public InsertDeleteGetRandomO1() {
        set = new HashSet<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        return set.add(val);
    }
    
    public boolean remove(int val) {
       return set.remove(val);
        
    }
    
    public int getRandom() {
        Iterator<Integer> iterator = set.iterator();
        int index = random.nextInt(set.size());

        while(iterator.hasNext()){
            if(index == 0) return iterator.next();
            iterator.next();
            index--;
        }  

        return 0;
    }
}