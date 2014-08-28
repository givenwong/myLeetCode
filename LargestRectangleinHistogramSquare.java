/*
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * */
public class LargestRectangleinHistogramSquare  {

	public int largestRectangleArea(int[] height) {
        
       int maxV = 0;   
    
       for(int i =0; i< height.length; i++){  
    	// if not peak node, skip it: the next try is higher and wider
            if(i< height.length-1 && height[i] <= height[i+1]) 
                 continue;  
            // minV is the minimum between i and j     
            int minV = height[i];   
            for(int j =i; j>=0; j--){
            	 // update the minimum height between i and j
                 minV = Math.min(minV, height[j]);   
                 int area = minV*(i-j+1);   
                 if(area > maxV)   
                 maxV = area;   
            }   
       }  
       return maxV; 
    }
}