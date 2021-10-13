package twitter.kd;

import java.util.Arrays;

public class KDifference {

    public static void main(String[] args) {
        int[] a = {1,3,5};
        int k = 2;
        System.out.println(kDifference(a, k));
    }

    public static int kDifference(int[] a, int k){
        Arrays.sort(a);
        int left = 0, right = 1;
        int len = a.length;
        int count = 0;
        while(right<len){
            if(a[right] - a[left] == k){
                count++;
                right++;
                while(right<len && a[right-1] == a[right]){
                    right++;
                }
            }else if(a[right] - a[left] > k){
                left++;
                while(left<right && a[left-1] == a[left]){
                    left++;
                }
            }else{
                right++;
                while(right<len && a[right-1] == a[right]){
                    right++;
                }
            }
            if(left==right){
                right++;
            }
        }
        return count;
    }
}
