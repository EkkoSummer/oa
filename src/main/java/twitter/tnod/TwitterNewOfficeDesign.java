package twitter.tnod;

public class TwitterNewOfficeDesign {
    public static void main(String[] args) {
//        int[] tablePositions = {1,2,4,7};
//        int[] tableHeights = {4,5,7,11};
//        int[] tablePositions = {1,3,7};
//        int[] tableHeights = {4,3,3};
        int[] tablePositions = {1,10};
        int[] tableHeights = {1,5};
        System.out.println(maxHeight(tablePositions, tableHeights));
    }

    public static int maxHeight(int[] tablePositions, int[] tableHeights){
        int num = tablePositions.length;
        int max = 0;
        for(int i=1; i<num; i++){
            int leftPos = tablePositions[i-1];
            int rightPos = tablePositions[i];
            int posDiff = rightPos - leftPos -1;
            if(posDiff<1) continue;
            int leftHeight = Math.min(tableHeights[i-1],tableHeights[i]);
            int rightHeight = Math.max(tableHeights[i-1],tableHeights[i]);
            int heightDiff = rightHeight-leftHeight;
            if(posDiff<=heightDiff){
                max = Math.max(max, leftHeight + posDiff);
            }else{
                max = Math.max(max, rightHeight + (posDiff - heightDiff + 1)/2);
            }
        }
        return max;
    }
}
