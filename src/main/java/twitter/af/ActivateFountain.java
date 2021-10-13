package twitter.af;

import java.util.Arrays;

public class ActivateFountain {

    public static void main(String[] args) {
        int[] a = {1,2,1};
        System.out.println(fountainActivation(a));
    }

    public static int fountainActivation(int[] a){
        int n = a.length;
        int[][] regions = new int[n][2];
        for(int i=0; i<n; i++){
            regions[i][0] = Math.max(0, i-a[i]);
            regions[i][1] = Math.min(n-1, i+a[i]);
        }
        Arrays.sort(regions, (r1,r2) -> r1[0] - r2[0]);
        //当前使用regions个数
        int ret = 0;
        //当前regions坐标
        int index = 0;
        //当前最右位置
        int right = 0;
        while(right<n){
            if(regions[index][0]>right){
                break;
            }
            int rt = right;
            while (index<n && regions[index][0]<=right){
                rt = Math.max(rt, regions[index++][1]);
            }
            right = rt;
            ret++;
            if(right == n-1){
                break;
            }
        }
        return right == n-1 ? ret : -1;
    }
}
