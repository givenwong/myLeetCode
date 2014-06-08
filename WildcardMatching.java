public class WildcardMatching{
		public boolean isMatch(String s, String p) {
       
        int star = -1; // position of last * in p
        int ss =0;     // position of last *'s opponent in s
        int posS =0;   // scanner for s
        int posP =0;   // scanner for p
        
        
        while (posS <= s.length()-1 ){
        
           if(posP <= p.length()-1){
            if ((p.charAt(posP)=='?')||(p.charAt(posP)==s.charAt(posS))){posS++;posP++;continue;}
            if (p.charAt(posP) =='*'){star=posP++; ss=posS;continue;}   // posP++: tentatively ignore the star in p but save positions                             
                                                                        // of star and its opponent for
                                                                        // potentail regret 
           }
            
            // regret
            if (star >= 0){ posP = star+1; posS=ss+1;/*start from the unmatched s's next*/ ss++; /*update the opponent pos*/ continue;}
            
            // two cases come to here: 1 need regret but there is no star 2 p is exausted but s is not
            return false;
        }
        
        // the remaining of has to be all *
        while (posP <= p.length()-1 && p.charAt(posP)=='*'){posP++;}
        return posP == p.length();
    }

}
