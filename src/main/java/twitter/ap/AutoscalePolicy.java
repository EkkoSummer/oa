package twitter.ap;

public class AutoscalePolicy {

    public static void main(String[] args) {
        int instances = 2;
        int[] averageUtil = {25,23,1,2,3,4,5,6,7,8,9,10,76,80};
        System.out.println(finalInstances(instances, averageUtil));
    }

    public static int finalInstances(int instances, int[] averageUtil){
        int MAX_INSTANCES = 2*(int)1e8;
        int n = averageUtil.length;
        for(int i=0; i<n; i++){
            if(averageUtil[i]<25){
                if(instances*2<=MAX_INSTANCES){
                    instances *=2;
                    i += 10;
                }
            }else if(averageUtil[i]>60){
                if(instances>1){
                    instances /=2;
                    i += 10;
                }
            }
        }
        return instances;
    }
}
