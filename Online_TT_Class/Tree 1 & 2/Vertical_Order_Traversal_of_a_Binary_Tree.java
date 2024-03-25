import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Vertical_Order_Traversal_of_a_Binary_Tree {
    
    Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

    public void solve(TreeNode root, int vL, int hL) {
        if(root == null) return;
        if (!map.containsKey(vL)) {
            map.put(vL, new TreeMap<>());
        }
        Map<Integer, PriorityQueue<Integer>> innerMap = map.get(vL);
        if (!innerMap.containsKey(hL)) {
            innerMap.put(hL, new PriorityQueue<>());
        }
        PriorityQueue<Integer> innerQueue = innerMap.get(hL);
        innerQueue.add(root.val);
        solve(root.left, vL-1, hL+1);
        solve(root.right, vL+1, hL+1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(root, 0, 0);
        for(Map.Entry<Integer, Map<Integer, PriorityQueue<Integer>>> outerEntry : map.entrySet()) {
            Map<Integer, PriorityQueue<Integer>> innerMap = outerEntry.getValue();
            List<Integer> temp = new ArrayList<>();
            for(Map.Entry<Integer, PriorityQueue<Integer>> innerEntry : innerMap.entrySet()) {
                PriorityQueue<Integer> queue = innerEntry.getValue();
                while(!queue.isEmpty()) {
                    temp.add(queue.remove());
                }
            }  
            ans.add(temp); 
        }
        return ans;
    }

}
