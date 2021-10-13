package twitter.pd;

import java.util.Arrays;

public class ParkingDilemma {

    public static void main(String[] args) {
//        int[] cars = {2,10,8,17};
//        int k = 3;
        int[] cars = {1,2,3,10};
        int k = 4;
        System.out.println(carParkingRoof(cars, k));
    }

    public static int carParkingRoof(int[] cars, int k){
        Arrays.sort(cars);
        int n = cars.length;
        int min = cars[n-1];
        for(int i=0; i+k-1<n; i++){
            int j = i + k - 1;
            min = Math.min(min, cars[j] - cars[i] + 1);
        }
        return min;
    }
}
