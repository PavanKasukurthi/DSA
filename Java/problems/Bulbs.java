/* Given N bulbs, either on (1) or off (0)
 * Turning on ith bulb causes all remaining bulbs on the right to flip
 * Find the minimum number of switches to turn on all the bulbs
 * 
 * Constraints:
 * 1 <= N <= 1e5
 * A[i] = {0,1}
 * 
 * https://www.interviewbit.com/problems/interview-questions/
*/

package Java.problems;

public class Bulbs {
    public static void main(String[] args) {
        int[] bulbs = {0,1,0,1};
        System.out.println(bulbSwitch(bulbs));
    }

    public static int bulbSwitch(int[] bulbs){
        int cost = 0;

        for(int bulb : bulbs){
            boolean isFlippedEvenTimes = cost%2 == 0;

            boolean isSwitchRequired = (bulb == 0 && isFlippedEvenTimes || bulb == 1 && !isFlippedEvenTimes);

            if(isSwitchRequired) cost++;
        }

        return cost;
    }
}
