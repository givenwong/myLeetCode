import java.util.*;
public class TextJustification  {
    public ArrayList<String> fullJustify(String[] words, int L) {
    
    ArrayList<String> res = new ArrayList<String>();
    if(words==null || words.length==0)
        return res;
    
    int count = 0; // count is the pure word length
    int last = 0;  // the total number of lines till the last line
    for(int i=0;i<words.length;i++)
    {
        if(count+words[i].length()+(i-last)>L) // if put words[i] in, each word needs at least one space, so put everything 
        {                                      // together to see if it exceeds L
            int spaceNum = 0; // each word is guaranteed to have this many spaces
            int extraNum = 0;
            
            if(i-last-1>0)
            {
                spaceNum = (L-count)/(i-last-1); // every word has these except for the last one of each line
                extraNum = (L-count)%(i-last-1);
            }
            
            StringBuilder str = new StringBuilder();
            for(int j=last;j<i;j++) // words[last], words[last+1], ... words[i-1]
            {
                str.append(words[j]);
                if(j<i-1)
                {
                    for(int k=0;k<spaceNum;k++)
                        str.append(" ");
                    
                    if(extraNum>0)
                        str.append(" ");
                  
                    extraNum--;
                }
            }
            // this is for the last word in each line
            for(int j=str.length();j<L;j++)
            	str.append(" ");
             
            res.add(str.toString());
            count=0;
            last=i;
        }
        count += words[i].length();
    }
    // the last line: left justified
    // the way to judge if it comes the last line is if put everything and it is no longer than L
    StringBuilder str = new StringBuilder();
    for(int i=last;i<words.length;i++)
    {
        str.append(words[i]);
        if(str.length()<L)
            str.append(" ");
    }
    for(int i=str.length();i<L;i++)
        str.append(" ");
    
    res.add(str.toString());
    return res;
 }
}