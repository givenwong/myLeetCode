public class LengthofLastWord  {
    public int lengthOfLastWord(String s) {
        
        StringBuffer buffer = new StringBuffer(s);
        buffer = buffer.reverse();
        String[] temp = buffer.toString().trim().split(" ");
        
        if(temp == null || temp.length ==0 )
         return 0;
         
        return temp[0].length();
    }
}