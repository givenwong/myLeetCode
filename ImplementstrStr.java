public class ImplementstrStr {
   public String strStr(String haystack, String needle) {
    if(haystack==null || needle==null) return null;
    if(haystack.length()==0){
        return needle.length()==0?"":null;
    }
    if(needle.length()==0) return haystack;
    if(haystack.length()<needle.length()) return null;

 int base = 29;
 long patternHash = 0;
    long tempBase = 1;

    for(int i=needle.length()-1; i>=0; i--){
     patternHash += (int)needle.charAt(i)*tempBase;
     tempBase *= base;
    }

    long hayHash = 0;
    tempBase = 1;
    for(int i=needle.length()-1; i>=0; i--){
     hayHash += (int)haystack.charAt(i)*tempBase;
     tempBase *= base;
    }
    tempBase /= base;

    if(hayHash == patternHash){
     return haystack;
    }

    for(int i=needle.length(); i<haystack.length(); i++){
     hayHash = (hayHash - (int)haystack.charAt(i-needle.length())*tempBase)*base+(int)haystack.charAt(i);
        if(hayHash == patternHash){
      return haystack.substring(i-needle.length()+1);
     }
    }
    return null;
} 
}