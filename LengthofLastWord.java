/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 *  return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.

*/

public class LengthofLastWord  {

	public int lengthOfLastWord(String s) {
        
        StringBuffer buffer = new StringBuffer(s);
        buffer = buffer.reverse();
        // trim() is for string
        // split() is for string
        // split() needs a char parameter and generates String[]
        String[] temp = buffer.toString().trim().split(" ");
        
        if(temp == null || temp.length ==0 )
         return 0;
         
        return temp[0].length();
    }
}