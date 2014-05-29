public class SingleNumberII  {
    public int singleNumber(int[] A) {
    
       int[] bitCount = new int[32];
       
        for(int j =0; j< 32; j++){
          for(int i = 0; i< A.length; i++){
                   bitCount[j] += (A[i]&(1<<j)) == 0?0:1; 
           }
       }
       
       int result = 0;
       for(int i =0; i< 32; i++){
           if(bitCount[i]%3 != 0)
           result |= (1<<i);
       }
    
    return result;
    }
}