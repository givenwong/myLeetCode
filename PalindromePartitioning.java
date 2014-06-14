import java.util.*;
public class PalindromePartitioning  {
    public ArrayList<ArrayList<String>> partition(String s) {
        
       ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
       ArrayList<String> temp = new ArrayList<String>();
       
       dfs(s,0,temp,result);
       
       return result;
    }
    
    boolean isPalindrome(String s, int front, int end){
        if(front > end)
        return false;
        
        while(front < end){
            if(s.charAt(front) != s.charAt(end))
            return false;
            front++;
            end--;
        }
        return true;
    }
    
    void dfs(String s, int start, ArrayList<String> temp, ArrayList<ArrayList<String>> result){
         
         if(start >= s.length()){
             result.add(new ArrayList<String>(temp));
             return;
         } 
         
         for(int i = start; i<s.length();i++){
             
             if(isPalindrome(s,start,i)){
                 temp.add(s.substring(start,i+1));
                 dfs(s,i+1,temp,result);
                 temp.remove(temp.size()-1);
             }
         }   
    }
}