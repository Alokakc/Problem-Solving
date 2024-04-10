import java.util.List;
class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}
public class Replace_Words {
    TrieNode root;
    public Replace_Words() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isEnd = true;
    }

    public String search(String word) {
        TrieNode node = root;
        String s = "";
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(node.children[c-'a'] == null) return word;
            s += c;
            node = node.children[c-'a'];
            if(node.isEnd) return s;
        }
        return word;
    }
    public String replaceWords(List<String> dict, String sen) {
        String ans = "";
        Replace_Words sol = new Replace_Words();
        for(String s: dict) sol.insert(s);
        String[] sent = sen.split(" ");
        for(int i=0; i<sent.length; i++) {
            ans += sol.search(sent[i]);
            if(i<sent.length-1) ans += " ";
        }
        return ans;
    }
}
