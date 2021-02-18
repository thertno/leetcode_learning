//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
//

             1
                     2 3
                     4 5

//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 104] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 设计 
// 👍 470 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    //迭代解法，层级遍历二叉树的代码框架
//    void traverse(TreeNode root) {
//        if (root == null) return;
//        // 初始化队列，将 root 加入队列
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//
//        while (!q.isEmpty()) {
//            TreeNode cur = q.poll();
//
//            /* 层级遍历代码位置 */
//            System.out.println(root.val);
//            /*****************/
//
//            if (cur.left != null) {
//                q.offer(cur.left);
//            }
//
//            if (cur.right != null) {
//                q.offer(cur.right);
//            }
//        }
//    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        StringBuilder stringBuider = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                stringBuider.append("#").append(",");
                continue;
            }
            stringBuider.append(temp.val).append(",");
            q.offer(temp.left);
            q.offer(temp.right);
        }
        System.out.println(stringBuider.toString());
        return stringBuider.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] str = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(str[0]));
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        for (int i = 1; i < str.length; ) {
            TreeNode temp = q.poll();
            String left = str[i++];
            if (!"#".equals(left)) {
                temp.left = new TreeNode(Integer.valueOf(left));
                q.offer(temp.left);
            } else {
                temp.left = null;
            }
            String right = str[i++];
            if (!"#".equals(right)) {
                temp.right = new TreeNode(Integer.valueOf(right));
                q.offer(temp.right);
            } else {
                temp.right = null;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
