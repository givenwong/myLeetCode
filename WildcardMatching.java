/*Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/
public class WildcardMatching {
	
		public boolean isMatch(String s, String p) {
       
        int star = -1; // position of the last * in p for regret
        int ss =0;     // position of last possible unmatched char for regret
        int posS =0;   // scanner for s
        int posP =0;   // scanner for p
        
        
        while (posS <= s.length()-1 ){
        
           if(posP <= p.length()-1){
            if ((p.charAt(posP)=='?')||(p.charAt(posP)==s.charAt(posS))){
            	posS++;
            	posP++;
            	continue;
            	}
            	
            if (p.charAt(posP) =='*'){
            	// posP++: tentatively ignore the star in p but save positions of star
            	// and its opponet's (the possible unmatched char) position for potential regret in the future
            	star=posP;
            	posP++;
            	ss=posS;
            	continue;
            	}                               
                                                                        
           }
            // regret
            // two cases come here: 1 p is exhausted 2 not matched
            // if p is exhausted, also have to regret to NOT use that many chars in p but just a *
            if (star >= 0){ 
            	posP = star+1; 
            	// start from the unmatched s's next char because the unmatched one is matched by star 
            	posS=ss+1;
            	// update the possible unmatched char
            	ss++;  
            	continue;
            	}
            
            // two cases come to here: 1 need regret but there is no star 2 p is exhausted but s is not and there is
            // no star
            return false;
        }
        
        // s is exhausted so the remaining of p has to be all *
        while (posP <= p.length()-1 && p.charAt(posP)=='*')
        	posP++;
        
        return posP == p.length();
    }
}
