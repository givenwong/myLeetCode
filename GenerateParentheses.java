import java.util.*;
public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        
     ArrayList<String> result = new ArrayList<String>();
     if(n<1)
     return result;
     
     helper(n,n,"",result);
     
     return result;
    }
    
    public void helper(int l, int r, String legalString, ArrayList<String> myResult){
    	// number of right parenthesis should be no less than that of left
        if(r<l)  
        return;   
        // one legal string is found, the search for this branch is finished
        if(l==0 && r==0)  
        myResult.add(legalString);  // there is no duplicate
       
        if(l>0)
        helper(l-1, r, legalString+"(", myResult);
        
        if(r>0)
        helper(l, r-1, legalString+")", myResult);      
    }  
}