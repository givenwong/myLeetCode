public class SortColors  {
   
    void swap(int A[], int i, int j){
    int tmp = A[i];
    A[i]=A[j];
    A[j]=tmp;
    }
    
    void sortColors(int A[]) {
        
        int red=0; // the pointer of the last red (actually the next position of last red)
        int blue=A.length-1; // the pointer of the first blue (actually the next position of the first blue)
         
        while (red < A.length && A[red]==0)
        	red++;
        while ( blue >= 0 && A[blue]==2)
        	blue--;
         
        int green=red; // i is a probe which scans from red to blue
                   // green is between red and i and i is the next position of the last green
                   // green or red or blue is between i and blue
        while (green<=blue){
            if (A[green]==0 && green >= red) {swap(A,green,red);red++;continue;}
            if (A[green]==2) {swap(A,green,blue);blue--;continue;}
            // the above two cases don't increase green as it is not green
            // here it increases green because it is green
            // if green < red, it comes here too
            green++;
        }
         
    }

}