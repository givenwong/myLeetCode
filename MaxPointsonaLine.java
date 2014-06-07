import java.util.*;

class Point{
    int x;
    int y;
    Point(){
    x = 0; 
    y = 0; 
    }
    Point(int a, int b){ 
  	  x = a; 
  	  y = b; 
  	  }
}
  public class MaxPointsonaLine {
    public int maxPoints(Point[] points) {
        
        if(points == null)
        System.exit(1);
        
        if(points.length == 0)
        return 0;
        
        int max = 0;
        for(int i = 0; i <= points.length -1; i++){
           HashMap<Double, Integer> slopeCount = new HashMap<Double, Integer>();
           // this is for the line passing only point i: can't identify its slope
           // so use the negative infinity
           slopeCount.put(Double.NEGATIVE_INFINITY,0);
           int dupCount = 0;
          
           for(int j = 0; j <= points.length-1; j++){
               if(i == j)
               continue;
               
               if(points[i].x == points[j].x && points[i].y == points[j].y ){
                   dupCount++;
                   continue;
               }
               
               if(points[i].x == points[j].x ){
                   if(slopeCount.get(Double.POSITIVE_INFINITY) == null)
                        slopeCount.put(Double.POSITIVE_INFINITY,1);
                   else    
                        slopeCount.put(Double.POSITIVE_INFINITY,1+slopeCount.get(Double.POSITIVE_INFINITY));
                        
                        continue;
               }
               
               double slope = (double)(points[i].y - points[j].y)/(double)(points[i].x - points[j].x);
               
                 if(slopeCount.get(slope) == null)
                        slopeCount.put(slope,1);
                 else    
                        slopeCount.put(slope,1+slopeCount.get(slope));
                        
                        continue; 
           }
               for(Double key : slopeCount.keySet())
                    slopeCount.put(key,dupCount+slopeCount.get(key)+1);
               for(Double key : slopeCount.keySet())
                    max =(slopeCount.get(key)>max)? slopeCount.get(key):max;
        }
        return max;
    }
}