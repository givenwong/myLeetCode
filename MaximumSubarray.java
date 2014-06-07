public class MaximumSubarray  {
    public int maxSubArray(int[] A) {
        
        int max =Integer.MIN_VALUE;
        int scanner =0;
        int temp =0;
        
        while(scanner < A.length){
             temp += A[scanner];
             max = (max > temp)?max:temp; 
            if(temp >=0)
            scanner++;
            else{
                scanner++;
                temp =0;
            }
        }
        return max;
    }
}