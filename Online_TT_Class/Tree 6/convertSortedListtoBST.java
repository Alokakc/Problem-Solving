public class convertSortedListtoBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.data);
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode newNode = new TreeNode(slow.next.data);
        ListNode nextHalf = slow.next.next;
        slow.next = null;
        newNode.left = sortedListToBST(head);
        newNode.right = sortedListToBST(nextHalf);
        return newNode;
    }
}
