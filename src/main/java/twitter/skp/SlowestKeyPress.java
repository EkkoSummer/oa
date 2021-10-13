package twitter.skp;

public class SlowestKeyPress {

    public static void main(String[] args) {
//        int[][] keyTimes = {{0,2},{1,5},{0,9},{2,15}};
//        int[][] keyTimes = {{0,2},{1,3},{0,7}};
        int[][] keyTimes = {{0,1},{0,3},{4,5},{5,6},{4,10}};
        System.out.println(slowestKey(keyTimes));
    }

    public static char slowestKey(int[][] keyTimes){
        int n = keyTimes.length;
        int longestTime = keyTimes[0][1];
        int slowestKeyIndex = keyTimes[0][0];
        for(int i=1; i<n; i++){
            if(keyTimes[i][1]-keyTimes[i-1][1] > longestTime){
                longestTime = keyTimes[i][1] - keyTimes[i-1][1];
                slowestKeyIndex = keyTimes[i][0];
            }
        }
        return (char)('a'+slowestKeyIndex);
    }
}
