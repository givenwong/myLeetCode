
import java.util.*;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        
        int last  = -1;   //index for the last unmatched ')'
        ArrayList<Integer> stack = new ArrayList<Integer>(); // for index of every unmatched '('
        int max = 0;
        
        for(int i = 0; i <= s.length()-1; i++){
            
            if(s.charAt(i) == '(')
                stack.add(i);
            else{
                
                if(stack.size() == 0)
                    last = i;
                else{
                    
                    stack.remove(stack.size()-1);
                    
                    if(stack.size() ==0)
                        max = (max> i-last)?max: i-last;
                    else
                        max = (max> i-stack.get(stack.size()-1))?max: i-stack.get(stack.size()-1); 
                   
                    
                    
                }
                
                
            }
                
            
            
            
        }
        
        return max;
        
    }
}