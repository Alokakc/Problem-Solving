public class convert_sorted_array_into_BST {
    public TreeNode helper(int start, int end, int[] nums){
        if(start>end) return null;
        int mid = (start+end)/2;
        TreeNode newNode = new TreeNode();
        newNode.val=nums[mid];
        newNode.left=helper(start, mid-1, nums);
        newNode.right=helper(mid+1, end, nums);
        return newNode;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length-1, nums);
    }
}
