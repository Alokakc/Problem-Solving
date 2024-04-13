class TrieNode {
    TrieNode zero, one;
    int count;
    TrieNode() {
        this.zero = this.one = null;
        this.count = 0;
    }
}
public class Count_Pairs_With_XOR_in_a_Range {

    public void insert(TrieNode root, int n) {
        TrieNode currNode = root;
        for(int i=14; i>=0; i--) {
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
            currNode.count += 1;
        }
    }

    public int getCount(TrieNode root) {
        return root == null ? 0 : root.count;
    }

    public int pairXor(TrieNode root, int val, int high) {
    if (root == null) return 0;
    int result = 0;
    TrieNode current = root;
    
    for (int i = 14; i >= -1; i--) {
        if(i == -1) {
            result += getCount(current);
            break;
        }
        int valBit = (val >> i) & 1;
        int highBit = (high >> i) & 1;
        
        if (valBit == 0) {
            if (highBit == 0) {
                current = current.zero;
            } else {
                result += getCount(current.zero);
                current = current.one;
            }
        } else {
            if (highBit == 0) {
                current = current.one;
            } else {
                result += getCount(current.one);
                current = current.zero;
            }
        }
        
        if (current == null) break;
    }
    
    return result;
}


    public int countPairs(int[] nums, int low, int high) {
        TrieNode root = new TrieNode();
        int ans = 0;
        for(int x: nums) {
            ans += pairXor(root, x, high);
            ans -= pairXor(root, x, low-1);
            insert(root, x);
        }
        return ans;
    }
}
