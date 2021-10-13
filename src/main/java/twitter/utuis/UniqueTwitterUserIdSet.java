package twitter.utuis;

import java.util.Arrays;

public class UniqueTwitterUserIdSet {

    public static void main(String[] args) {
        int[] arr = {3,2,1,2,7};
        System.out.println(getUniqueUserIdSum(arr));
    }

    public static int getUniqueUserIdSum(int[] arr){
        Arrays.sort(arr);
        int sum = 0;
        int low = 0;
        for(int a : arr){
            low = Math.max(low+1, a);
            sum += low;
        }
        return sum;
    }
}
