import java.util.*;

public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
         
          if(triangle == null)
          System.exit(1);
          
          if(triangle.size() ==1)
          return triangle.get(0).get(0);

         for(int i =1; i <= triangle.size()-1; i++){
        	  // set the first element of each level
              triangle.get(i).set(0,triangle.get(i).get(0) + triangle.get(i-1).get(0));
              for(int j =1; j <= i-1; j++){
              int min = (int)Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j));
              triangle.get(i).set(j,triangle.get(i).get(j) + min);
              }
              // set the last element of each level
              triangle.get(i).set(i,triangle.get(i).get(i) + triangle.get(i-1).get(i-1) ); 
         } 
          int min = Integer.MAX_VALUE;
          for(Integer temp: triangle.get(triangle.size()-1))
              min = (min<temp)?min:temp;
              
          return min;       
    }
}