import java.util.*;
class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  }
 
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        if(node == null)
        return null;
        
         ArrayList<UndirectedGraphNode> queue = new ArrayList<UndirectedGraphNode>();
         // map is to connect the old and new graph
         HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new  HashMap<UndirectedGraphNode,UndirectedGraphNode>();
         
         queue.add(node);
         UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
         map.put(node,copy);
         
         while(queue.size()>0){
             UndirectedGraphNode current = queue.get(0);
             queue.remove(0);
             ArrayList<UndirectedGraphNode> neighbors = (ArrayList)current.neighbors;
             
             for(UndirectedGraphNode a: neighbors){
                 // the if else judgment is to avoid duplicates
            	 if(!map.containsKey(a)){
                     queue.add(a);
                     UndirectedGraphNode temp = new UndirectedGraphNode(a.label);
                     map.put(a,temp);
                     map.get(current).neighbors.add(temp);         
                 }else{
                     map.get(current).neighbors.add(map.get(a));
                 }
             }
         }
         return copy;
    }
}