package twitter.ad;

import java.util.Arrays;

public class AnagramDifference {

    public static void main(String[] args) {
        String[] a = {"a", "jk", "abb", "mn", "abc"};
        String[] b = {"bb", "kj", "bbc", "op", "def"};
        System.out.println(Arrays.toString(getMinimumDifference(a,b)));
    }

    public static int[] getMinimumDifference(String[] a, String[] b){
        int n = a.length;
        int[] ret = new int[n];
        for(int i=0; i<n; i++){
            ret[i] = helper(a[i], b[i]);
        }
        return ret;
    }

    public static int helper(String a, String b){
        if(a.length() != b.length()){
            return -1;
        }
        int[] countA = new int[26];
        for(char c : a.toCharArray()){
            countA[c-'a']++;
        }
        int[] countB = new int[26];
        for(char c : b.toCharArray()){
            countB[c-'a']++;
        }
        int countSame = 0;
        for(int i=0; i<26; i++){
            countSame += Math.min(countA[i], countB[i]);
        }
        return a.length() - countSame;
    }
}
