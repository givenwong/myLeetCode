import java.util.*;

public class LargestRectangleinHistogramLinear {
    public int largestRectangleArea(int[] height) {
        
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        
        h = Arrays.copyOf(height, height.length + 1);  // the last element of h is zero
        
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        
        
        return maxArea;
        
    }
}