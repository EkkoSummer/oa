package twitter.gsg;

public class GetSetGo {

    public static void main(String[] args) {
//        int[] calCounts = {2,9,5,1,6};
//        int requiredCals = 12;
        int[] calCounts = {2,3,15,1,16};
        int requiredCals = 8;
        System.out.println(isPossible(calCounts, requiredCals));
    }

    public static boolean isPossible(int[] calCounts, int requiredCals){
        return dfs(calCounts, 0, 0, requiredCals);
    }

    public static boolean dfs(int[] calCounts, int i, int current, int requiredCals){
        if(current == requiredCals) {
            return true;
        }
        //eat
        if(i<calCounts.length && current + calCounts[i] <= requiredCals){
            if(dfs(calCounts, i+1, current + calCounts[i], requiredCals)){
                return true;
            }
        }
        //not eat
        if(i<calCounts.length && dfs(calCounts, i+1, current, requiredCals)){
            return true;
        }
        return false;
    }
}
