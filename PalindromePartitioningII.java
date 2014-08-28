public class PalindromePartitioningII  {
    public int minCut(String s) {
        
        if(s==null||s.length()==0||s.length()==1) {
            return 0;
        }
        // it is the dp matrix to decide if it is a palindrome
        boolean[][] palindrome_map = new boolean[s.length()][s.length()];
        // the number of cuts of string from i to s.length()
        int[] cut_num_array = new int[s.length()+1];
        
        for(int i=s.length()-1;i>=0;i--) {
            cut_num_array[i] = s.length() - i;
            // try every position within (i,s.length()-1) to see if get a smaller number
            for(int j=s.length()-1;j>=i;j--) {
                if(s.charAt(i)==s.charAt(j)) {
                    if(j-i<2||palindrome_map[i+1][j-1]) {
                        palindrome_map[i][j]=true;
                        cut_num_array[i] = Math.min(cut_num_array[i], cut_num_array[j+1]+1);
                    }
                }
            }
            
        }
    
        return cut_num_array[0] - 1;
    }
}