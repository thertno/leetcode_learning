//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树 
// 👍 229 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return result;
    }

    List<TreeNode> result = new ArrayList();

    Map<String, Integer> map = new HashMap();

    public String traverse(TreeNode head) {
        if (head == null) {
            return "#";
        }
        String left = traverse(head.left);
        String right = traverse(head.right);
        String temp = left + "," + right + "," + head.val;
        int count = map.getOrDefault(temp, 0);
        if (count == 1) {
            result.add(head);
        }
        map.put(temp, count + 1);
        System.out.println(temp);
        return temp;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
