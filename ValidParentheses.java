import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        
        StringBuffer stack = new StringBuffer();
        HashMap<Character, Character> map = new  HashMap<Character, Character>();
        map.put(new Character(')'),new Character('('));
        map.put(new Character('}'),new Character('{'));
        map.put(new Character(']'),new Character('['));
    
        
        for(char tempChar : s.toCharArray()){
            
            if(tempChar == '(' ||tempChar == ')' ||tempChar == '{' ||tempChar == '}' ||tempChar == '[' ||tempChar == ']')
                if( stack.length() ==0 ||map.get(new Character(tempChar))== null ||!map.get(new Character(tempChar)).equals(new Character(stack.charAt(stack.length()-1))))
                    stack.append(tempChar);
                else
                    stack.deleteCharAt(stack.length()-1);
            
        }
        
        return stack.length()==0;
        
        
        
    }
    
    public static void main(String[] args){
    	
    	Solution mySolution = new Solution();
    	boolean myResult = mySolution.isValid("((");
    	
    	System.out.println(myResult);
    }
}