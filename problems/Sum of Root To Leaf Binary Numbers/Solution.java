/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public int dfs(TreeNode node, int sum){
        if(node == null) return 0;   
        sum = (sum*2 + node.val)%1000000007;
        if(node.left == null && node.right == null){
            return sum%1000000007;
        } else return (dfs(node.left, sum)+dfs(node.right, sum))%1000000007;
    }
    
    public int sumRootToLeaf(TreeNode root) {
        int sum = 0;
        //ArrayList<Integer> bits = new ArrayList<Integer>();
        return dfs(root, 0);
    }
}
