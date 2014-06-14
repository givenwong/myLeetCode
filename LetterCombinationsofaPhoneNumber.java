import java.util.*;
public class LetterCombinationsofaPhoneNumber {
    public ArrayList<String> letterCombinations(String digits) {
        
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> resultPrevious = new ArrayList<String>();
        
        if(digits == null)
        System.exit(1);
        // this is the base case
        if(digits.length() == 0)
        {result.add("");
        return result;
        }
        
        char[][] dic = {{'a','b','c','\0'},{'d','e','f','\0'}, {'g','h','i','\0'}, {'j','k','l','\0'}, {'m','n','o','\0'}, {'p','q','r','s'},{'t','u','v','\0'},{'w','x','y','z'}};
        // remove the ones
        StringBuffer buffer = new StringBuffer();
        for(char temp: digits.toCharArray())
            if (temp != '1')
                buffer.append(temp);
        String digitsNoOnes = buffer.toString();
        // the recursion
        resultPrevious = letterCombinations(digitsNoOnes.substring(1));
        
        for(char tempChar : dic[digitsNoOnes.charAt(0)-'0'-2]){
            // if tempChar is not an empty char
        	if(tempChar != '\0')
            for(String tempString: resultPrevious){
                StringBuffer tempBuffer = new StringBuffer(tempString);
                tempBuffer.reverse();
                tempBuffer.append(tempChar);
                tempBuffer.reverse();
                result.add(tempBuffer.toString());
            }     
        }
        return result;   
    }
}