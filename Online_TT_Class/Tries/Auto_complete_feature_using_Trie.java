import java.util.*;

class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    List<String> CommonPrefixNames;
    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
        CommonPrefixNames = new ArrayList<>();
    }
}
public class Auto_complete_feature_using_Trie {
    TrieNode root;
    public Auto_complete_feature_using_Trie() {
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
            node.CommonPrefixNames.add(word);
        }
        node.isEnd = true;
    }
    public List<String> search(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(node.children[c-'a'] == null) return new ArrayList();
            node = node.children[c-'a'];
        }
        return node.CommonPrefixNames;
    }
    public static void main(String[] args) {
        Auto_complete_feature_using_Trie obj = new Auto_complete_feature_using_Trie();
        List<String> l = Arrays.asList("hello", "dog", "hell", "cat", "a", "hel","help","helps","helping");
        for(String s: l) {
            obj.insert(s);
        }
        System.out.println(obj.search("hel"));
    }
}
