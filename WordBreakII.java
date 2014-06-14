import java.util.*;
// this combines dp and dfs
// dp is to reduce the number of branches of dfs
public class WordBreakII {   
	
    boolean[] dp;
    
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
          
        int length = s.length(); 
        dp = new boolean[length];
        
        for(int i =0; i<= length -1;i++){            
            // this string itself is in the dictionary
            if(dict.contains(s.substring(0,i+1))){
            dp[i] = true;
            continue;    
            }
            // one of the segmentation is true
            for(int j =1; j<=i;j++){
                if(dp[j-1] == true && dict.contains(s.substring(j,i+1))){
                 dp[i] = true;
                 break;
                }
            }
        }
        
        dfs(s,dict,length-1,"", result);
        return result;         
    }
    
    // in the dfs, the string grows from back to front
    public void dfs(String s, Set<String> dict, int end ,String temp, ArrayList<String> result){
    	      // the base case
              if(end == -1){
                  result.add(temp);
                  return;
              }
              
              String temptemp = temp;
              for(int i = end; i >=0 ; i--){
            	  
                     if((i==0 ||dp[i-1] == true) && dict.contains(s.substring(i,end+1))){
                         if(temp == "")
                         temp =s.substring(i,end+1);
                         else
                         temp = s.substring(i,end+1) + " " + temp;
                    
                         dfs(s,dict,i-1,temp,result);
                         // make sure dfs doesn't change the temp string
                         temp = temptemp;
                     } 
              }    
    }
}