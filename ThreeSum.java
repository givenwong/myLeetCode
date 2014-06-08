import java.util.*;
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        
       if(num==null)
        return null;
       
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       if(num.length ==0 )
        return result;
       
       // to use the two-pointer method, needs to sort the array first
       Arrays.sort(num);
       
       
       for(int i = 0; i <= num.length-3; i++){ // i is the index of the first numble in the tuplet
          if(i==0 || num[i] != num[i-1]){   // this condition is to avoid dups: num[i] is its first appearance!
          int target = -1*num[i];
          int front = i+1;
          int end = num.length-1;
          while(front < end){ 
             if(num[front] + num[end] == target){
                 ArrayList<Integer> temp = new ArrayList<Integer>();
                 temp.add(num[i]);
                 temp.add(num[front]);
                 temp.add(num[end]);
                 result.add(temp);
                 
                   front++;
                   end--;
                   
                   while(front < end && num[front] == num[front-1]) // skip the dups
                   front++;
                   while(front < end && num[end] == num[end+1]) // skip the dups
                   end--;
                    
             }else if(num[front] + num[end] > target){
                 end--;
             }else{
                 front++;
             }
          }
        }      
    }
    
    return result; 
    }
}