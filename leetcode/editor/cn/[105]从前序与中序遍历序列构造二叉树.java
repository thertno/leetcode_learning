//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 867 👎 0


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int pl, int pr,
                          int[] inorder, int il, int ir) {
        if (pl > pr) {
            return null;
        }
        int rootVal = preorder[pl];
        int index = 0;
        for (int i = il; i <= ir; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        int leftSize = index - il;
        TreeNode treeNode = new TreeNode(rootVal);
        treeNode.left = build(preorder, pl + 1, pl + leftSize, inorder, il, index - 1);
        treeNode.right = build(preorder, pl + leftSize + 1, pr, inorder, index + 1, ir);
        return treeNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
