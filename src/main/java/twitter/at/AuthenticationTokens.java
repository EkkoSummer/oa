package twitter.at;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationTokens {

    public static void main(String[] args) {
        int expiryLimit = 4;
        int[][] commands = {{0,1,1},{0,2,2},{1,1,5},{1,2,7}};
        System.out.println(numberOfTokens(expiryLimit, commands));
    }

    public static int numberOfTokens(int expiryLimit, int[][] commands){
        Arrays.sort(commands, (c1,c2) -> c1[2]-c2[2]);
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] command : commands){
            int type = command[0], id = command[1], T = command[2];
            if(type==0){
                map.put(id, T + expiryLimit);
            }else{
                if(!map.containsKey(id)){
                    continue;
                }
                if(map.get(id)>=T){
                    map.put(id, T + expiryLimit);
                }
            }
        }
        int count = 0;
        int lastTime = commands[commands.length-1][2];
        for (int id : map.keySet()){
            if(map.get(id)>=lastTime){
                count++;
            }
        }
        return count;
    }
}
