package twitter.bsa;

import java.util.Arrays;

public class BalancedSalesArray {

    public static void main(String[] args) {
        int[] sales = {1,2,3,3};
        System.out.println(balancedSum(sales));
    }

    public static int balancedSum(int[] sales){
        int ret = 0;
        int sum = Arrays.stream(sales).sum();
        int preSum = 0;
        for(int i=0; i<sales.length; i++){
            if(preSum * 2 + sales[i] == sum){
                ret = i;
                break;
            }
            preSum += sales[i];
        }
        return ret;
    }
}
