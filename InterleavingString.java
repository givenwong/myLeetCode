public class InterleavingString  {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int n1 = s1.length();
        int n2 = s2.length();
        
        boolean[][] A = new boolean[n1+1][n2+1];
        if (n1+n2!=s3.length()){return false;}
        if (s1.length() == 0 && s2.length() == 0 && s3.length() ==0){return true;}
          
        A[0][0]=true;    
        for (int i=1;i<=n1;i++){
            if (s1.charAt(i-1)==s3.charAt(i-1) && A[i-1][0]){A[i][0]=true;}
        }
        for (int i=1;i<=n2;i++){
            if (s2.charAt(i-1)==s3.charAt(i-1) && A[0][i-1]){A[0][i]=true;}
        }       
        for (int i=1;i<=n1;i++){
            for (int j=1;j<=n2;j++){
                A[i][j]= (A[i][j-1] && (s2.charAt(j-1)==s3.charAt(i+j-1))) || (A[i-1][j]&& (s1.charAt(i-1)==s3.charAt(i+j-1)));   
            }
        }
        return A[n1][n2];   
    }
    
}