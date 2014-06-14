import java.util.Arrays;

public class ThreeSumClosest {

	public int threeSumClosest(int[] num, int target) {
        
        if(num == null)
        System.exit(1);
        
        if(num.length == 0 || num.length ==1  || num.length == 2 )
        System.exit(1);
        
        // to use the two pointer method has to sort the array first
        Arrays.sort(num);
        
        int sum = 0; // the result to return
        int diff = Integer.MAX_VALUE;
        
        for(int i =0; i <= num.length -3; i++ ){    
        	
             int front = i+1;
             int end = num.length-1;
             
             while(front<end){
            	  // update the best result so far
            	  // the i + front + end == target case is not included as just want to find the closest
                  if(diff > Math.abs(num[i] + num[front] + num[end] - target)){
                   sum = num[i] + num[front] + num[end];
                   diff = Math.abs(num[i] + num[front] + num[end]- target);
                   }
                  
                 if(num[i] + num[front] + num[end] > target)
                     end--;
                 else front++;
             }
        }
        
        return sum;
    }
}