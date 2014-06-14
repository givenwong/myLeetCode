public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        return numTreesHelper(1, n);
    }
    
    public int numTreesHelper(int start, int end){
        if(start == end)
        return 1;
        
        int totalNum =0;
        // try each number in this range as the root
        for(int i = start+1; i<= end-1; i++)
            totalNum += numTreesHelper(start,i-1)*numTreesHelper(i+1,end);
        
        // start or end as the root and the left or the right subtree is null
        totalNum += numTreesHelper(start+1,end) + numTreesHelper(start,end-1);
        
        return totalNum;
    }
}