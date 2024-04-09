class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    int count;
    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
        count = 0;
    }
}
public class Sum_of_Prefix_Scores_of_Strings {
    TrieNode root = new TrieNode();
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
            node.count++;
        }
        node.isEnd = true;
    }
    public int search(String word) {
        TrieNode node = root;
        int ans = 0;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(node.children[c-'a'] == null) return ans;
            node = node.children[c-'a'];
            ans += node.count;
        }
        return ans;
    }
    public int[] sumPrefixScores(String[] words) {
        int[] ans = new int[words.length];
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }
        for(int i=0; i<words.length; i++) {
            String s = words[i];
            ans[i] = search(s);
        }
        return ans;
    }
}
