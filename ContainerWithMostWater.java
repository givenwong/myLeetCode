public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        
        if(height.length <= 1)
            return 0;
            
        int front = 0;
        int end = height.length -1;
        int max = (end - front)*((height[front] <= height[end])?height[front]:height[end]); 
        
        while(front < end){
            
            int area;
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