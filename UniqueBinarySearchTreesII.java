import java.util.*;
public class UniqueBinarySearchTreesII  {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = numTreesHelper(1,n);
        return result;   
    }
    
    public List<TreeNode> numTreesHelper(int start, int end){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(start > end){
        result.add(null);
        return result;
        }
       
        for(int i = start; i<= end; i++){
            List<TreeNode> leftTreeList = numTreesHelper(start,i-1);
            List<TreeNode> rightTreeList = numTreesHelper(i+1,end);
            for(int j =0; j< leftTreeList.size();j++){
                for(int k =0; k< rightTreeList.size();k++){
                    TreeNode resultRoot = new TreeNode(i);
                    resultRoot.left = leftTreeList.get(j);
                    resultRoot.right =rightTreeList.get(k);
                    result.add(resultRoot);
                }
            }
        }
        return result;
    }
}