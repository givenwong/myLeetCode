import java.util.*;

public class Permutations {
	
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        
        ArrayList<ArrayList<Integer>> myResult = new ArrayList<ArrayList<Integer>>();
        permuteHelper(num, 0, myResult );
        
        return myResult;
        
    }
    
      public void permuteHelper(int[] num, int start, ArrayList<ArrayList<Integer>> result ) {
         
             if(num == null || start > num.length -1)
                return;
             
             if(start == num.length-1){
                  ArrayList<Integer> temp = new ArrayList<Integer>();
                  for(int t : num)
                      temp.add(t); 
                  result.add(temp);
                  return;
                }
         
           // put num[start], num[start+1], num[start+2],...,num[length-1] at front and permute the remaining
             for(int i = start; i <= num.length-1; i++){  
                 // to prevent duplicates
                 if(num[i] != num[start]){
                 int swap;
                 swap = num[i];
                 num[i] = num[start];
                 num[start] = swap;
           
                 permuteHelper(num, start + 1, result );
                 
                 swap = num[i];
                 num[i] = num[start];
                 num[start] = swap;
                 }   
             }
    }
    
}