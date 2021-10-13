package twitter.wf;

import java.util.Arrays;

/**
 * Example 1:
 *
 * Input: [1, 0, 0, 1, 0]
 * Output: 0
 * Explanation:
 * If you answer 0 questions (k = 0) your_result = 0 and your friend_result = -1 (2 correct answers and 3 wrong answers).
 * Example 2:
 *
 * Input: [1, 0, 0, 1, 1]
 * Output: 1
 * Example 3:
 *
 * Input: [1, 1, 1, 0, 1]
 * Output: 2
 */

public class WeirdFaculty {

    public static void main(String[] args) {
        int[] v ={1, 1, 1, 0, 1};
        System.out.println(exam(v));
    }

    public static int exam(int[] v){
        int len = v.length;
        int right = Arrays.stream(v).sum();
        int wrong = len - right;
        //edge case
        if(right<wrong){
            return 0;
        }
        int target = (right - wrong)/2 + 1;
        int score = 0;
        for(int i=0; i<len; i++){
            if(v[i]==1){
                score++;
                if(score>=target){
                    return i+1;
                }
            }else{
                score--;
            }
        }
        return 0;
    }
}
