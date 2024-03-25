import java.util.*;
public class Odd_even_level_difference {
    int getLevelDiff(TreeNode root)
	{
	    //code here
	    int evenSum = 0, oddSum = 0;
	    boolean flag = true, check = true;
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.add(root);
	    while(!queue.isEmpty()) {
	        if(check) {
	            flag = true;
	            check = false;
	        } else {
	            flag = false;
	            check = true;
	        }
	        int n = queue.size();
	        for(int i=0; i<n; i++) {
	            TreeNode temp = queue.remove();
	            if(flag) {
	                evenSum += temp.val;
	            } else {
	                oddSum += temp.val;
	            }
	            if(temp.left!=null) queue.add(temp.left);
	            if(temp.right!=null) queue.add(temp.right);
	        }
	    }
	    return evenSum-oddSum;
	}
}
