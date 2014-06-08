public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        
        if (S == null || T == null || S.length() == 0 || T.length() == 0) {
            return "";
        }
        
        int[] needToFind = new int[256];
        int[] hasFound = new int[256];      // these two only contain chars in T

        for (int i = 0; i < T.length(); i++) 
            needToFind[T.charAt(i)]++;
        

        int minWinLen = Integer.MAX_VALUE;
        int count = 0, tLen = T.length();
        int winBeg = 0, winEnd = 0;
        
        for (int begin = 0, end = 0; end < S.length(); end++) {
        	// if this is something not interesting, continue
            if (needToFind[S.charAt(end)] == 0) 
                continue;
            
            hasFound[S.charAt(end)]++;
            if(hasFound[S.charAt(end)] <= needToFind[S.charAt(end)])
                count ++;  // count how many valid T chars are found 
            
            if(count == tLen){ // if all are found, then begin reducing
                while(needToFind[S.charAt(begin)] == 0 || hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]){
                    if(hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]){
                        hasFound[S.charAt(begin)]--;
                    }
                    begin ++;
                }
                
                int winLen = end - begin + 1;
                if(winLen < minWinLen){
                    winBeg = begin;
                    winEnd = end;
                    minWinLen = winLen;
                }
            } 
        }

        if (count == T.length()) {
            return S.substring(winBeg, winEnd + 1);
        }
        return "";
    }
}