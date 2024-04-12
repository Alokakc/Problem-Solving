class TrieNode {
    TrieNode zero, one;
}

public class Maximum_XOR_of_Two_Numbers_in_an_Array {

    public void insert(TrieNode root, int n) {
        TrieNode currNode = root;
        for(int i=31; i>=0; i--) {
            int currBit = (n>>i)&1;
            if(currBit == 0) {
                if(currNode.zero == null) {
                    currNode.zero = new TrieNode();
                }
                currNode = currNode.zero;
            }
            else {
                if(currNode.one == null) {
                    currNode.one = new TrieNode();
                }
                currNode = currNode.one;
            }
        }
    }

    public int maxXOR(TrieNode root, int n) {
        TrieNode currNode = root;
        int ans = 0;
        for(int i=31; i>=0; i--) {
            int currBit = (n>>i)&1;
            if(currBit == 1) {
                if(currNode.zero != null) {
                    ans += 1<<i;
                    currNode = currNode.zero;
                }
                else {
                    currNode = currNode.one;
                }
            }
            else {
                if(currNode.one != null) {
                    ans += 1<<i;
                    currNode = currNode.one;
                }
                else {
                    currNode = currNode.zero;
                }
            }
        }
        return ans;
    }

    public int findMaximumXOR(int[] nums) {
        int ans = -1;
        TrieNode root = new TrieNode();
        for(int x: nums) insert(root, x);
        for(int x: nums) {
            ans = Math.max(ans, maxXOR(root, x));
        }
        return ans;
    }
}