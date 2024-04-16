
class TrieNode {
    TrieNode[] children;
    int length;
    int index;
    TrieNode() {
        this.children = new TrieNode[26];
        this.length = 5*1001;
    }
}
class Longest_Common_Suffix_Queries_better_improvement {

    public void Insert(TrieNode currRoot, int n, int index) {
        if(currRoot.length > n) {
            currRoot.length = n;
            currRoot.index = index;
        }
    }

    public void insert(TrieNode root, String s, int index) {
        TrieNode currRoot = root;
        int n = s.length();
        Insert(currRoot, n, index);
        for(int i=n-1; i>=0; i--) {
            char c = s.charAt(i);
            if(currRoot.children[c-'a'] == null) currRoot.children[c-'a'] = new TrieNode();
            currRoot = currRoot.children[c-'a'];
            Insert(currRoot, n, index);
        }
    }

    public int search(TrieNode root, String s) {
        TrieNode currRoot = root;
        int n = s.length();
        for(int i=n-1; i>=0; i--) {
            char c = s.charAt(i);
            if(currRoot.children[c-'a'] == null) return currRoot.index;
            currRoot = currRoot.children[c-'a'];
        }
        return currRoot.index;
    }

    public int[] stringIndices(String[] wC, String[] wQ) {
        TrieNode root = new TrieNode();
        int[] ans = new int[wQ.length];
        for(int i=0; i<wC.length; i++) {
            insert(root, wC[i], i);
        }
        for(int i=0; i<wQ.length; i++) {
            ans[i] = search(root, wQ[i]);
        }
        return ans;
    }
}
