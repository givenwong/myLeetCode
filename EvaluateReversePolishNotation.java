import java.util.*;

public class EvaluateReversePolishNotation{
    public int evalRPN(String[] tokens) {
        
        ArrayList<Integer> stack = new ArrayList<Integer>();
        
        for(String current : tokens){
            
            int temp =0;
            if(current.equals("+")){
                temp = stack.get(stack.size()-1).intValue() + stack.get(stack.size()-2).intValue();
                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);
                stack.add(new Integer(temp));
                continue;
            }
            if(current.equals("-")){
                temp = stack.get(stack.size()-2).intValue() - stack.get(stack.size()-1).intValue();
                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);
                stack.add(new Integer(temp));
                continue;
            }
            if(current.equals("*")){
                temp = stack.get(stack.size()-1).intValue() * stack.get(stack.size()-2).intValue();
                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);
                stack.add(new Integer(temp));
                continue;
            }
            if(current.equals("/")){
                temp = stack.get(stack.size()-2).intValue() / stack.get(stack.size()-1).intValue();
                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);
                stack.add(new Integer(temp));
                continue;
            }
            
            stack.add(new Integer(current));
            
        }
        
        return stack.get(0).intValue();
    }
    
   
}