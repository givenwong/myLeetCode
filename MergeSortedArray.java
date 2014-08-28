public class MergeSortedArray  {
    
	public void merge(int A[], int m, int B[], int n) {
      // from the back to the front so don't have to re-shuffle the elements  
       while(m > 0 && n > 0){
    	   // append the bigger one at the end
            if(A[m-1] > B[n-1]){
                A[m+n-1] = A[m-1];
                m--;
            }else{
                A[m+n-1] = B[n-1];
                n--;
            }
        }
       
       while(n > 0){
            A[m+n-1] = B[n-1];
            n--;
        }
    }
}