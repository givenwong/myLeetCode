/*Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code"*/
import java.util.*;

public class WordBreak {

	public boolean wordBreak(String s, Set<String> dict) {
        
    	// HashSet object has a method: boolean myHashSet.contains();
    	
        int length = s.length(); 
        // dp[i]: if s.substring(0,i+1) can be "word broken"
        boolean[] dp = new boolean[length];
        
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
       return dp[length-1]; 
    }
}