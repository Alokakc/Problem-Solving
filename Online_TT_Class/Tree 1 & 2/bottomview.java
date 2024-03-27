import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Pair{
    TreeNode node;
    int level;
    public Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
public class bottomview {
    static void bottomView(TreeNode root, Map<Integer, Integer> map) {
        Queue<Pair> q = new LinkedList<>();
        Pair pair = new Pair(root, 0);
        q.add(pair);
        while(!q.isEmpty()) {
            Pair temp = q.remove();
            TreeNode n = temp.node;
            int lev = temp.level;
            map.put(lev, n.val);
            if(n.left != null) q.add(new Pair(n.left, lev-1));
            if(n.right != null) q.add(new Pair(n.right, lev+1));
        }
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        bottomView(root, map);
        for(Map.Entry<Integer, Integer> m: map.entrySet()) {
            ans.add(m.getValue());
        }
        return ans;
    }
}
