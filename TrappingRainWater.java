public class TrappingRainWater  {
	
    public int trap(int[] A) {
/*For each bar, the water itself can trap depends on the max  height on its left and right, 
 *e.g.  if current bar is of height 2, the max height on its left is 4, max height on its 
 *right is 3, then water can be trapped in this bar is min(4,3)-2 = 1.
 */
        if (A.length<2){return 0;}    
         
        int[] l = new int[A.length];
        int[] r = new int[A.length];
         
        int water =0;
         
        l[0]=0;
        for (int i=1;i<A.length;i++)
            l[i]= (int)Math.max(l[i-1], A[i-1]);
        
                 
        r[A.length-1] = 0;
        for (int i=A.length-2;i>=0;i--)
            r[i]=(int)Math.max(r[i+1],A[i+1]);
        
         
        for (int i=0;i<A.length;i++){
            if (Math.min(l[i],r[i])-A[i] >0 )
                water += (int)Math.min(l[i],r[i])-A[i];
            
        }
         
        return water;    
    }
}