//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 518 👎 0


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

    /**
     * 递归解法
     * 使用迭代解法
     *
     * @param root
     * @return
     */
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList();
//        postorder(root, list);
//        return list;
//    }
//
//    public void postorder(TreeNode root, List<Integer> list) {
//        if (root == null) {
//            return;
//        }
//        postorder(root.left, list);
//        System.out.println(root.val);
//        postorder(root.right, list);
//
//        list.add(root.val);
//    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> q = new Stack();
        q.push(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.pop();
            list.add(0, temp.val);
            if (temp.left != null) {
                q.push(temp.left);
            }
            if (temp.right != null) {
                q.push(temp.right);
            }
        }
        return list;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
