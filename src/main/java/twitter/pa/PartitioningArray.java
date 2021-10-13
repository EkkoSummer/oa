package twitter.pa;

import java.util.HashMap;
import java.util.Map;

public class PartitioningArray {

    public static void main(String[] args) {
//        int k = 2;
//        int[] numbers = {1,2,3,4};
        int k = 3;
        int[] numbers = {1,2,2,4};
        System.out.println(solve(k, numbers));
    }

    public static String solve(int k, int[] numbers){
        int n = numbers.length;
        if(n%k!=0){
            return "No";
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        int max = 0;
        for(int num : numbers){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            max = Math.max(max, countMap.get(num));
        }
        return max<=n/k ? "Yes" : "No";
    }
}
