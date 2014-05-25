import java.util.*;

public class PascalsTriangleII {
    public ArrayList<Integer> getRow(int rowIndex) {
        
     
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        ArrayList<Integer> secondRow = new ArrayList<Integer>();
        secondRow.add(1);
        secondRow.add(1);
     
        if(numRows ==0)
        return null;
     
        if(numRows ==1){
        return firstRow;
        }
        
         if(numRows ==2){
        return secondRow);
        }
        
        result.add(firstRow);     
        result.add(secondRow);
        
        while(numRows >=3 ){
        ArrayList<Integer> lastRow = result.get(result.size()-1);
        ArrayList<Integer> newRow = new ArrayList<Integer>();
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