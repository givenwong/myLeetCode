public class DecodeWaysDFS {
    int num;
    public int numDecodings(String s) {
        if (s.length()==0) 
        	return 0;
        num = 0;
        dfs(s);
        return num;
    }
    
    // dfs is to check if the remaining string could be decoded 
    public void dfs(String s){
    	// the whole string passes the check then num++
        if (s.length()==0) 
        	num++;
        for(int i=0;i<=1&&i<s.length();i++){
            if (isValid(s.substring(0,i+1)))
                dfs(s.substring(i+1));
        }
    }
    
    public boolean isValid(String s){
        if (s.charAt(0)=='0') 
        	return false;
        int code = Integer.parseInt(s);
        return code>=1 && code<=26;
    }
}