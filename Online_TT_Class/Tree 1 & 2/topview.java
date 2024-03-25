import java.util.*;
class Pair{
    TreeNode node;
    int level;
    public Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
public class topview {
    static void topView(TreeNode root, Map<Integer, Integer> map) {
        Queue<Pair> q = new LinkedList<>();
        Pair pair = new Pair(root, 0);
        q.add(pair);
        while(!q.isEmpty()) {
            Pair temp = q.remove();
            TreeNode n = temp.node;
            int lev = temp.level;
            if(!map.containsKey(lev)) {
                map.put(lev, n.val);
            }
            if(n.left != null) q.add(new Pair(n.left, lev-1));
            if(n.right != null) q.add(new Pair(n.right, lev+1));
        }
    }
    static ArrayList<Integer> topView(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        topView(root, map);
        for(Map.Entry<Integer, Integer> m: map.entrySet()) {
            ans.add(m.getValue());
        }
        return ans;
    }
}
