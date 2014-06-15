import java.util.*;

// From String to int: Integer.ParseInt(String)
// from int/Integer to String: Integer.toString(int/Integer);

public class RestoreIPAddresses {
    
        public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s.length()<4||s.length()>12) return res;
        dfs(s,"",res,0);
        return res;
    }
    
    public void dfs(String s, String tmp, ArrayList<String> res, int count){
    	// Count is the number of IP sections already built
    	// s is the remaining part of the String s
        if (count == 3 && isValid(s)) {
            res.add(tmp + s); // String not the StringBuffer! String is immutable but StringBuffer is so need new StringBuffer()...
            return;
        }
        // tentative dfs search
        for(int i=1; i<4 && i<s.length(); i++){
            String substr = s.substring(0,i);
            if (isValid(substr)){
                dfs(s.substring(i), tmp + substr + '.', res, count+1);
            }
        }
    }
    
    public boolean isValid(String s){
    	// if starts with a zero the whole String has to be a zero
        if (s.charAt(0)=='0') return s.equals("0");
        int num = Integer.parseInt(s);
        // the valid range is 0 to 255
        return num<=255 && num>0;
    }
        

}