public class LargestRectangleinHistogramSquare  {
    public int largestRectangleArea(int[] height) {
        
       int maxV = 0;   
       for(int i =0; i< height.length; i++)  
       {  
            if(i< height.length-1 && height[i] <= height[i+1]) // if not peak node, skip it  
                 continue;  
                 
            int minV = height[i];   
            for(int j =i; j>=0; j--)   
            {   
                 minV = Math.min(minV, height[j]);   
                 int area = minV*(i-j+1);   
                 if(area > maxV)   
                 maxV = area;   
            }   
       }  
       return maxV; 
    }
}