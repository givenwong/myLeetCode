import java.util.*;


public class FourSum {
	
	    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
	        
	        ArrayList<ArrayList<Integer>> resultFinal = new ArrayList<ArrayList<Integer>>();
	        
	        if(num == null)
	        System.exit(1);
	        
	        if(num.length < 4)
	        return resultFinal;
	        
	    
	        HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
	        Arrays.sort(num);
	        
	        for(int i=0; i<= num.length-1; i++){
	            for(int j=i+1;j <= num.length-1;j++){
	                
	                int front= j+1;
	                int end = num.length-1;
	                
	                
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
