/*Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, 
then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?*/
public class SortColors  {
   
    void swap(int A[], int i, int j){
    int tmp = A[i];
    A[i]=A[j];
    A[j]=tmp;
    }
    
    void sortColors(int A[]) {
        
    	// red and blue are the savers while green is the probe!!!!!!!!!!!!!!!!!!!
    	
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
        	
            if (A[green]==0 && green >= red) {
            	swap(A,green,red);
            	red++;
            	continue;
            	}
            
            if (A[green]==2) {
            	swap(A,green,blue);
            	blue--;
            	continue;
            	}
            // the above two cases don't increase green as A[green]  is not "green"
            // here it increases green because it is green
            // if green < red, it comes here too because it needs adjust the probe green
            green++;
        }
         
    }

}