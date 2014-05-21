public class SqrtX  {
    public int sqrt(int x) {
        
        if(x < 0)
        System.exit(1);
        
        if(x ==0)
        return 0;
        
        if (x==1) {return 1;}
        
        long low = 0;
        long high = x;
        
 while (high-low >1){
   long mid = (high+low)/2;
         if (mid*mid<=x){low = mid;}
         else {high = mid;}
}

        
        return (int)low;
        
    }
}