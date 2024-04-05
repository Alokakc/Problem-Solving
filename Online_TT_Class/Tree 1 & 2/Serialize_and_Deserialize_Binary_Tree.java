import java.util.LinkedList;
import java.util.Queue;

public class Serialize_and_Deserialize_Binary_Tree {
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        String str = "";
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode temp = q.remove();
            if(temp == null) {
                str += "n ";
                continue;
            }
            str += temp.val+" ";
            q.add(temp.left);
            q.add(temp.right);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] info = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(info[0]));
        q.add(root);
        for(int i=1; i<info.length; i++) {
            TreeNode parent = q.remove();
            if(!info[i].equals("n")) {
                TreeNode child = new TreeNode(Integer.parseInt(info[i]));
                parent.left = child;
                q.add(child);
            }
            if(!info[++i].equals("n")) {
                TreeNode child = new TreeNode(Integer.parseInt(info[i]));
                parent.right = child;
                q.add(child);
            }
        }
        return root;
    }
}
