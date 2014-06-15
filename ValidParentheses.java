import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        
        StringBuffer stack = new StringBuffer();
        // HashMap has methods: put(key, value); get(key)
        HashMap<Character, Character> map = new  HashMap<Character, Character>();
        // only ) } ] need to be canceled out by popping out its opponent from the stack
        map.put(new Character(')'),new Character('('));
        map.put(new Character('}'),new Character('{'));
        map.put(new Character(']'),new Character('['));
    
        
        for(char tempChar : s.toCharArray()){
            
            if(tempChar == '(' ||tempChar == ')' ||tempChar == '{' ||tempChar == '}' ||tempChar == '[' ||tempChar == ']')
                if( stack.length() ==0 ||map.get(new Character(tempChar))== null ||!map.get(new Character(tempChar)).equals(new Character(stack.charAt(stack.length()-1))))
                    stack.append(tempChar);
                else
                    // the top element of the stack is the opponent to the coming char
                	// then pops it out to cancel the coming char
                	stack.deleteCharAt(stack.length()-1);
        }
        
        return stack.length()==0;
      
    }
}