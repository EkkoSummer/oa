package twitter.sp;

import java.util.HashSet;
import java.util.Set;

public class SubPalindrome {

    public static void main(String[] args) {
        String s = "aabaa";
        System.out.println(palindrome(s));
    }

    public static int palindrome(String s){
        int len = s.length();
        //dp[i][j] represents whether s.subtring(i,j) is palindromic
        boolean[][] dp = new boolean[len+1][len+1];
        Set<String> set = new HashSet<>();
        for(int i=0; i<len; i++){
            dp[i][i] = true;
            dp[i][i+1] = true;
            set.add(s.substring(i,i+1));
        }
        char[] cc = s.toCharArray();
        for(int subLen=2; subLen<=len; subLen++){
            for(int i=0; i+subLen<=len; i++){
                int j = i + subLen;
                if(dp[i+1][j-1] && cc[i]==cc[j-1]){
                    dp[i][j] = true;
                    set.add(s.substring(i,j));
                }
            }
        }
        return set.size();
    }
}
