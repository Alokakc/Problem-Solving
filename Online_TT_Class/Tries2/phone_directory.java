import java.util.*;

class TrieNode {
    TrieNode[] children;
    ArrayList<Integer> commonPrefixContact;
    TrieNode() {
        children = new TrieNode[26];
        commonPrefixContact = new ArrayList<>();
    }
}
class phone_directory{
    static void insert(TrieNode root, String s, int index) {
        TrieNode currNode = root;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(currNode.children[c-'a'] == null) {
                currNode.children[c-'a'] = new TrieNode();
            }
            currNode = currNode.children[c-'a'];
            currNode.commonPrefixContact.add(index);
        }
    }
    
    static void search(TrieNode root, String s, ArrayList<ArrayList<String>> ans, List<String> contact) {
        TrieNode currNode = root;
        int i=0;
        for(i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(currNode.children[c-'a'] == null) break;
            currNode = currNode.children[c-'a'];
            ArrayList<String> temp = new ArrayList<>();
            for(Integer it: currNode.commonPrefixContact) temp.add(contact.get(it));
            Collections.sort(temp);
            ans.add(temp);
        }
        ArrayList<String> zero = new ArrayList<>();
        zero.add("0");
        for(int j=i; j<s.length(); j++) ans.add(zero);
        return;
    }
    
    static ArrayList<ArrayList<String>> displayContacts(int n, String ct[], String s) {
        TrieNode root = new TrieNode();
        Set<String> set = new HashSet<>();
        List<String> contact = new ArrayList<>();
        for(String st: ct) set.add(st);
        for(String st: set) contact.add(st);
        for(int i=0; i<contact.size(); i++) {
            insert(root, contact.get(i), i);
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        search(root, s, ans, contact);
        return ans;
    }
}