public class SortColors  {
   
          
    void swap(int A[], int i, int j){
    int tmp = A[i];
    A[i]=A[j];
    A[j]=tmp;
    }
    
    void sortColors(int A[]) {
        
        int n = A.length;
        int red=0;
        int blue=n-1;
         
       
        while (red < n && A[red]==0){red++;}
        while ( blue >= 0&& A[blue]==2){blue--;}
         
        int i=red;
        while (i<=blue){
            if (A[i]==0 && i>red) {swap(A,i,red);red++;continue;}
            if (A[i]==2) {swap(A,i,blue);blue--;continue;}
            i++;
        }
         
    }
        
  
}