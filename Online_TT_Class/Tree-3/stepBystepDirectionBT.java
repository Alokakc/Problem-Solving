public class stepBystepDirectionBT {
    class Solution {
        String hold = "";
        public void solve(TreeNode root, int s, StringBuilder str) {
            if(root == null) return;
            if(root.val == s) {
                hold = str.toString();
                return;
            }
            str.append("L");
            solve(root.left, s, str);
            str.delete(str.length()-1, str.length());
            str.append("R");
            solve(root.right, s, str);
            str.delete(str.length()-1, str.length());
        }
        public String getDirections(TreeNode root, int s, int e) {
            StringBuilder str = new StringBuilder();
            solve(root, s, str);
            String s1 = hold;
            solve(root, e, str);
            String s2 = hold;
            String ans = "";
            int i=0, j=0;
            while(i<s1.length() && j<s2.length()) {
                if(s1.charAt(i)==s2.charAt(j)) {
                    i++; j++;
                } else break;
            }
            while(i<s1.length()) {
                ans += "U"; i++;
            }
            while(j<s2.length()) {
                ans += s2.charAt(j); j++;
            }
            return ans;
        }
    }
}
