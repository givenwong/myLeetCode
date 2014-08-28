import java.util.*;
public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
	        
	        ArrayList<ArrayList<Integer>> resultFinal = new ArrayList<ArrayList<Integer>>();
	        
	        if(num == null)
	        System.exit(1);
	        
	        if(num.length < 4)
	        return resultFinal;
	        // Set to avoid duplicates 
	        HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
	        // sort: 1 result is in ascending order 2 use the two scanner approach
	        Arrays.sort(num);     
	        for(int i=0; i<= num.length-4; i++){ // the first number
	            for(int j=i+1;j <= num.length-3;j++){ // the 2nd number
	                
	                int front= j+1; // the 3rd number
	                int end = num.length-1; // the 4th number
	                while(front < end){
	                    if(num[front]+num[end] == target - num[i] - num[j]){
	                        ArrayList<Integer> temp = new ArrayList<Integer>();
	                        temp.add(num[i]);
	                        temp.add(num[j]);
	                        temp.add(num[front]);
	                        temp.add(num[end]);
	                        result.add(temp);
	                        front++;  
	                    }else if(num[front]+num[end] < target - num[i] - num[j]){
	                        front++;
	                    } else{
	                        end--;
	                    }  
	                }
	            }    
	        }
	        if(result.size() == 0)
	        return resultFinal;
	        
	        for(ArrayList<Integer> item : result)
	        resultFinal.add(item);
	        
	        return resultFinal;   
	}
}
