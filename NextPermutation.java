/*

Step 1: Find the largest index k, such that A[k]<A[k+1]. If not exist, this is the last permutation. (in this    problem just sort the vector and return.)
Step 2: Find the largest index l, such that A[l]>A[k].
Step 3: Swap A[k] and A[l].
Step 4: Reverse A[k+1] to the end.


*/





public class NextPermutation {
    public void nextPermutation(int[] num) {
        
        int k = -1;
        int l = -1;
        int swap;
        
        
        for(int i =0; i<= num.length-2;  i++){
            if(num[i]<num[i+1])
                k = i;
        }
        
        if(k == -1){
            
            for(int front = 0, end = num.length-1; front < end; front ++, end--){
            swap = num[front];
            num[front] = num[end];
            num[end] = swap;
        }
              return;
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
        
        
    }
}