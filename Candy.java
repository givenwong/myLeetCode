public class Candy  {
    public int candy(int[] ratings) {
    
     if(ratings == null || ratings.length ==0)
     return 0;
     
     int[] resultArray = new int[ratings.length];
     resultArray[0] = 1;
     
     for(int i=1; i<ratings.length; i++){
         if(ratings[i]>ratings[i-1])
            resultArray[i] = resultArray[i-1]+1;
         else
            resultArray[i] = 1;
            
     }
     
        for(int i=ratings.length -2; i >=0; i--){
       
         if(ratings[i]>ratings[i+1] &&  resultArray[i] <= resultArray[i+1])
            resultArray[i] = resultArray[i+1]+1;
       
     }
     
     int result =0;
     
     for(int temp: resultArray)
         result += temp;
         
         return result;
     
        
    }

}