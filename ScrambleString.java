import java.util.*;

public class ScrambleString  {

    public boolean isScramble(String s1, String s2) {
       
       if(s1 == null || s2 == null)
       return false;
       
       // a necessary condition: same length
       if(s1.length() != s2.length())
       return false;
           
       char[] one = s1.toCharArray();
       char[] two = s2.toCharArray();
       
       Arrays.sort(one);
       Arrays.sort(two);
       
       // one more necessary condition: same content
       for(int i =0; i<= s1.length()-1;i++)
           if(one[i] != two[i])
           return false;
       
       if(s1.equals(s2)) 
    	   return true; // base case;
       
       for(int split = 1; split < s1.length(); split++){
       
    	   String s11 = s1.substring(0, split);
           String s12 = s1.substring(split);
           
           String s21 = s2.substring(0, split);
           String s22 = s2.substring(split);
           
           if(isScramble(s11, s21) && isScramble(s12, s22)) 
        	   return true;
           
           s21 = s2.substring(0, s2.length() - split);
           s22 = s2.substring(s2.length() - split);
           
           if(isScramble(s11, s22) && isScramble(s12, s21)) 
        	   return true;
       }
       
       return false;  
    }
}