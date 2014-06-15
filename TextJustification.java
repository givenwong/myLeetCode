import java.util.*;

public class TextJustification {

	public ArrayList<String> fullJustify(String[] words, int L) {
    
    ArrayList<String> res = new ArrayList<String>();
    if(words==null || words.length==0) // Array has filed length
        return res;
    
    int count = 0; // count is the pure word length in each line
    int last = 0;  // the index of the first word in each line
    for(int i=0;i<words.length;i++){
    	
        if(count+words[i].length()+(i-last)>L){ // if put words[i] in, each word needs at least one space,  
                                                // so put everything together to see if it exceeds L
        	                                    // and then to process this line
            int spaceNum = 0; // each word is guaranteed to have this many spaces
            int extraNum = 0;
            
            if(i-last-1>0){
            
            	spaceNum = (L-count)/(i-last-1); // every word has these except for the last one of each line
                extraNum = (L-count)%(i-last-1);
            }
            // StringBuffer has methods: toString(), StringBuffer(String), deleteCharAt(index), append(), 
            // setCharAt(index), length(), charAt(index)
            StringBuffer str = new StringBuffer();
            for(int j=last;j<i;j++){ // words[last], words[last+1], ... words[i-1] is in this line
                                     // words[i] is in the next line
                str.append(words[j]);
                if(j<i-1){
                	
                    for(int k=0;k<spaceNum;k++)
                        str.append(" ");
                    
                    if(extraNum>0)
                        str.append(" "); // Not guaranteed each word can get one
                  
                    extraNum--;
                }
            }
            // this is for the last word (i-1) in each line in one case:
            // there is only one word in each line and it can only be left justified and has to pad spaces to the right
            for(int j=str.length();j<L;j++)
            	str.append(" ");
             
            res.add(str.toString());
            count=0; // initialize count = 0 for next line
            last=i;
        }
        count += words[i].length();
    }
    // the last line: left justified
    // the way to judge if it comes the last line : if put in everything (and finish all words[]) and it is no longer than L
    StringBuffer str = new StringBuffer();
    for(int i=last;i<words.length;i++){
        str.append(words[i]);
        if(str.length()<L)
            str.append(" "); // in the very last line, each word has one space
    }
    for(int i=str.length();i<L;i++)// padding
        str.append(" ");
    
    res.add(str.toString());
    return res;
 }
}