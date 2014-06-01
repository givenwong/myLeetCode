public class InterleavingStringDFS {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        return dfs(s1,s2,s3,0,0,0);
    }
    
    public boolean dfs(String s1, String s2, String s3, int a, int b, int c){
        
        if(s1.length()-a+s2.length()-b != s3.length()-c)
        return false;
        
        if(s1.length()-a ==0 && s2.length()-b == 0 && s3.length()-c ==0)
        return true;
        
        if(s1.length()-a ==0)
        return s2.substring(b).equals(s3.substring(c));
        if(s2.length()-b ==0)
        return s1.substring(a).equals(s3.substring(c));
        
        
        if(s1.charAt(a) == s3.charAt(c) && s2.charAt(b) != s3.charAt(c) )
        return dfs(s1,s2,s3,a+1, b, c+1);  
        
        if(s1.charAt(a) != s3.charAt(c) && s2.charAt(b) == s3.charAt(c) )
        return dfs(s1,s2,s3,a, b+1, c+1);  
        
        if(s1.charAt(a) == s3.charAt(c) && s2.charAt(b) == s3.charAt(c) )
        return dfs(s1,s2,s3,a+1, b, c+1) || dfs(s1,s2,s3,a, b+1, c+1);  
        
        return false;
        
    }

}