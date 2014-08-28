import java.util.*;

public class PascalsTriangle  {
	
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        ArrayList<Integer> secondRow = new ArrayList<Integer>();
        secondRow.add(1);
        secondRow.add(1);
     
        if(numRows ==0)
        return result;
     
        if(numRows ==1){
        result.add(firstRow);
        return result;
        }
        
        if(numRows ==2){
        result.add(firstRow);     
        result.add(secondRow);
        return result;
        }
        
        result.add(firstRow);     
        result.add(secondRow);
        
        while(numRows >=3 ){
        ArrayList<Integer> lastRow = result.get(result.size()-1);
        ArrayList<Integer> newRow = new ArrayList<Integer>();
        // construct the new row
        newRow.add(1);
        for(int i =0; i<= lastRow.size()-2;i++)
            newRow.add(lastRow.get(i)+ lastRow.get(i+1));
        newRow.add(1);
        
        result.add(newRow); 
         
        numRows--;
       }
       
        return result;
    }
}