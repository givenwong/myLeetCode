import java.util.HashMap;


public class TwoSum {
	
	    public int[] twoSum(int[] numbers, int target) {
	        
	        HashMap<Integer, Integer> myHashMap = new HashMap<Integer, Integer>();
	        int[] result = new int[2];
	        
	        for(int i = 0; i< numbers.length; i++)
	            myHashMap.put(numbers[i],i);
	        
	        for(int i = 0; i< numbers.length; i++){
	            if (myHashMap.get(target - numbers[i]) != null && myHashMap.get(target - numbers[i]) != i)
	            {   
	                result[0] = i+1;
	                result[1] = myHashMap.get(target - numbers[i])+1;
	                return result;
	                
	            }
	        }
	        
	        return null;
	}
	    
	    
	    public static void main(String[] args){
	    	
	    	int[] myNumbers = {3,2,4};
	    	int myTarget = 6;
	    	int[] myResult;
	    	TwoSum myTwoSum = new TwoSum();
	    	
	    	myResult = myTwoSum.twoSum(myNumbers, myTarget);
	    	System.out.println(myResult[0]);
	    	System.out.println(myResult[1]);
	    	
	    	
	    }
	    
	
	

}
