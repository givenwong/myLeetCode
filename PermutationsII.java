import java.util.*;

public class PermutationsII  {
    
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> myResult = new ArrayList<ArrayList<Integer>>();
    
         ArrayList<Integer> temp1 = new ArrayList<Integer>();
        for(int i = 0; i<= num.length-1; i++)
          temp1.add(num[i]);
          
         myResult.add(temp1);
        
        while(nextPermutation(num)){
           
         ArrayList<Integer> temp = new ArrayList<Integer>();
           for(int i = 0; i<= num.length-1; i++)
          temp.add(num[i]);
          
            myResult.add(temp);
       
        }

       
        return myResult;
        
        
    }
    
    
    public boolean nextPermutation(int[] num) {
        
        int k = -1;
        int l = -1;
        int swap;
        
        
        for(int i =0; i<= num.length-2;  i++){
            if(num[i]<num[i+1])
                k = i;
        }
        
        if(k == -1){
            
              return false;
        }
          
            
        for(int i =k; i<= num.length-1;  i++){
            if(num[k]<num[i])
                l = i;
        }    
        
      
        swap = num[k];
        num[k] = num[l];
        num[l] = swap;
        
        for(int front = k+1, end = num.length-1; front < end; front ++, end--){
            swap = num[front];
            num[front] = num[end];
            num[end] = swap;
        }
        
        return true;
    }
    
    
   
    
}
        
        
    
