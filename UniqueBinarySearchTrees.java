public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        
        return numTreesHelper(1, n);
        
    }
    
    public int numTreesHelper(int start, int end){
        
        if(start == end)
        return 1;
        
        int totalNum =0;
        for(int i = start+1; i<= end-1; i++){
            totalNum += numTreesHelper(start,i-1)*numTreesHelper(i+1,end);
        }
        
        totalNum += numTreesHelper(start+1,end) + numTreesHelper(start,end-1);
        
        return totalNum;
        
    }
}