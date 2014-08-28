/*
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints 
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water.

Note: You may not slant the container*/
public class ContainerWithMostWater {
	
    public int maxArea(int[] height) {
        
        if(height.length <= 1)
            return 0;
            
        int front = 0;
        int end = height.length -1;
        int max = (end - front)*((height[front] <= height[end])?height[front]:height[end]); 
        while(front < end){
            int area;
            // height[front] is the sucker
            if(height[front] <= height[end]){
                area = (end - front)*height[front]; 
                max = (max > area)? max:area;
                front++;
            }else{
                area = (end - front)*height[end]; 
                max = (max > area)? max:area;
                end--;
            }
        }
        return max; 
    }
}