public class MedianofTwoSortedArrays  {
    public double findMedianSortedArrays(int A[], int B[]) {
        
        int[] mySumArray = new int[A.length + B.length];
        int a = 0, b = 0, c =0;
        
        while(a < A.length && b < B.length){
            if(A[a] < B[b]){
            mySumArray[c] = A[a];
            a++;
            }
            else{
            mySumArray[c] = B[b];
            b++;
            }
           c++;
        }
        
        if(a == A.length && b < B.length )
            while(b<B.length){
                mySumArray[c] = B[b];
                b++;
                c++;
            }
        else 
            if(a < A.length && b == B.length )
                while(a<A.length){
                    mySumArray[c] = A[a];
                    a++;
                    c++;
                }
        
        
    
     if(mySumArray.length%2 == 1)
        return (double) mySumArray[(mySumArray.length -1)/2];
     else
        return (double)(0.5*mySumArray[(mySumArray.length -1)/2] + 0.5*mySumArray[(mySumArray.length +1)/2]); 
        
        
        
        
    }
}