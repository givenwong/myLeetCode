import java.util.*;

public class GrayCode {
    // generate the grayCode by recursion
	// to get the n bit gray code, need to generate the n-1 bit first
	public ArrayList<Integer> grayCode(int n) {
    	
        if(n==0) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }
        
        ArrayList<Integer> tmp = grayCode(n-1);
    
        int addNumber = 1 << (n-1);
        // result of next round is the union of this round and the new which is by adding a 1 at the first bit
        ArrayList<Integer> result = new ArrayList<Integer>(tmp);
        
        for(int i=tmp.size()-1;i>=0;i--) 
            result.add(addNumber + tmp.get(i)); // pay attention: it is add operator "+"
        
        return result;
    }
}