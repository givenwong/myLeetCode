/*There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?*/


public class Candy  {
	
    public int candy(int[] ratings) {
    
     if(ratings == null || ratings.length ==0)
     return 0;
     
     int[] resultArray = new int[ratings.length];
     resultArray[0] = 1;
     // the first scan: each child gets more candies than its left neighbor if its score is higher
     for(int i=1; i<ratings.length; i++){
         if(ratings[i]>ratings[i-1])
            resultArray[i] = resultArray[i-1]+1;
         else
            resultArray[i] = 1;    
     }
  // the 2nd scan: each child gets more candies than its right neighbor if its score is higher
  // if he already got more candies, make no change   
     for(int i=ratings.length -2; i >=0; i--){
         if(ratings[i]>ratings[i+1] &&  resultArray[i] <= resultArray[i+1]) // resultArray[i] may be greater than resultArray[i+1] more than 1
            resultArray[i] = resultArray[i+1]+1;                            // so need to enforce the 2nd condidition
     }
     
     int result =0;
     for(int temp: resultArray)
         result += temp;
         
         return result; 
    }
}