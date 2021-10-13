package twitter.ucf;

import java.util.Arrays;

public class UniversityCareerFair {

    public static void main(String[] args) {
        int[] arrival = {1,3,3,5,7};
        int[] duration = {2,2,1,2,1};
        System.out.println(maxEvents(arrival, duration));
    }

    public static int maxEvents(int[] arrival, int[] duration){
        int len = arrival.length;
        //[start][end]
        int[][] activities = new int[len][2];
        for(int i=0; i<len; i++){
            activities[i][0] = arrival[i];
            activities[i][1] = arrival[i] + duration[i];
        }
        Arrays.sort(activities, (a1,a2) -> a1[1] - a2[1]);
        int count = 1;
        int end = activities[0][1];
        for(int[] activity : activities){
            if(activity[0]>=end){
                end = activity[1];
                count++;
            }
        }
        return count;
    }
}
