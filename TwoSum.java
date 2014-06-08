import java.util.HashMap;
public class TwoSum {
	    public int[] twoSum(int[] numbers, int target) {
	        
	        HashMap<Integer, Integer> myHashMap = new HashMap<Integer, Integer>();
	        int[] result = new int[2];
	        
	        for(int i = 0; i< numbers.length; i++)
	            myHashMap.put(numbers[i],i);
	            
	        for(int i = 0; i< numbers.length; i++){
	        	// can't use the num[i] twice
	            if (myHashMap.get(target - numbers[i]) != null && myHashMap.get(target - numbers[i]) != i)
	            {   
	                result[0] = i+1;
	                result[1] = myHashMap.get(target - numbers[i])+1;
	                return result;  
	            }
	        }
	        return null;
	}
}
