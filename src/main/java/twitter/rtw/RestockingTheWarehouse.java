package twitter.rtw;

public class RestockingTheWarehouse {

    public static void main(String[] args) {
        int[] itemCount = {10,20,30,40,15};
        int target = 80;
        System.out.println(restock(itemCount, target));
    }

    public static int restock(int[] itemCount, int target){
        int sum = 0;
        for(int item : itemCount){
            if(sum>=target){
                break;
            }
            sum += item;
        }
        return Math.abs(sum - target);
    }
}
