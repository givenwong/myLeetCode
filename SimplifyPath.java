import java.util.*;

public class SimplifyPath  {
	
    public String simplifyPath(String path) {
        
        if(path.length() == 0){
			return path;
		}
		// String has method split() and its parameter is some String
        // and its output is some String[]
		String[] splits = path.split("/"); // this also deletes all consecutive / and tailing /
		
		// LinkedList can be directly used as a stack 
		LinkedList<String> stack = new LinkedList<String>();
		
		for (String s : splits) {
			
			if(s.length()==0 || s.equals(".")){ 
				continue;
			}else if(s.equals("..")){ // go up (skip) one level of folder in the path
				if(!stack.isEmpty())
					stack.pop();
				
			}else{
				stack.push(s);
			}
		}
		
		// it is important to put something "" into the stack so the result will start with "/"
		if(stack.isEmpty()){
			stack.push("");
		}
		// the result is built from front to end
		String ret = "";
		while(!stack.isEmpty()){
			// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			// LinkedList has methods: push() to the head of the list
			// pop() from the head of the list
			// removeLast() remove from the tail of the list
			
			
			ret = ret + "/" + stack.removeLast(); 
		}
		
		return ret;
        
    }
}