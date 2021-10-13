package twitter.fdp;

import java.util.*;

public class FinalDiscountedPrice {

    public static void main(String[] args) {
        int[] prices = {2,3,1,2,4,2};
//        int[] prices = {2,3,5,2,4,1};
//        int[] prices = {2,4,3,2,4,6};
        finalPrice(prices);
    }

    public static void finalPrice(int[] prices){
        long total = 0;
        Deque<Integer> stack = new LinkedList<>();
        int len = prices.length;
        List<Integer> indexes = new ArrayList<>();
        for(int i=0; i<len; i++){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                if(prices[stack.peek()]<prices[i]){
                    stack.push(i);
                }else{
                    indexes.add(i);
                    while(!stack.isEmpty() && prices[stack.peek()]>=prices[i]){
                        total += prices[stack.poll()] - prices[i];
                    }
                    stack.push(i);
                }
            }
        }
        while(!stack.isEmpty()){
            total += prices[stack.poll()];
        }
        System.out.println(total);
        System.out.println(indexes);
    }
}
