
public class RomanToInteger {

	
	int romanToInt(String s) {
	    if (s.length()==0) return 0;
       
	    int[] m = new int['Z']; 
	 
	    m['I'] = 1;
	    m['V'] = 5;
	    m['X'] = 10;
	    m['L'] = 50;
	    m['C'] = 100;
	    m['D'] = 500;
	    m['M'] = 1000;

	    int n = s.length();
	    int sum = m[s.charAt(n-1)];
	    for (int i=n-2; i>=0; i--) {
	        if ( m[s.charAt(i)]>= m[s.charAt(i+1)])
	            sum += m[s.charAt(i)];
	        else
	            sum -= m[s.charAt(i)];
	    }
	    return sum;
	}
	
	
}
