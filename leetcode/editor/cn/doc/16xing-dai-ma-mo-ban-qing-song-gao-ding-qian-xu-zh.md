前序遍历
### 解题思路
主要思想：
  先取根节点的值，再遍历左子树，再遍历右子树
步骤：
步骤一：取根节点的值
步骤二：遍历左子树
步骤三：遍历右子树
### 代码
```
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||(!stack.empty())){
            if(root!=null){
                list.add(root.val);//步骤一，取根节点的值
                stack.push(root);//把根节点放入栈中
                root=root.left;//步骤二，遍历左子树
            }
            else{
                TreeNode tem=stack.pop();
                root=tem.right;//步骤三，遍历右子树
            }
        }
        return list;
    }
}
```

中序遍历
### 解题思路
主要思想：
  先遍历左子树，再取根节点的值，再遍历右子树
步骤：
步骤一：遍历左子树
步骤二：取根节点的值
步骤三：遍历右子树
### 代码
```
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||(!stack.empty())){
            if(root!=null){
                stack.push(root);//把根节点放入栈中
                root=root.left;//步骤一，遍历左子树
            }
            else{
                TreeNode tem=stack.pop();
                list.add(tem.val);//步骤二，取根结点的值
                root=tem.right;//步骤三，遍历右子树
            }
        }
        return list;
    }
}
```

后序遍历
### 解题思路
主要思想：
  先遍历左子树，再遍历右子树，最后取根节点的值
步骤：(对主要思想里边的步骤逆序处理)
步骤一：取根节点的值，插入list最后边
步骤二：遍历右子树
步骤三：遍历左子树
### 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||(!stack.empty())){
            if(root!=null){
             stack.push(root);//把根节点放入栈中
             list.add(0,root.val);//步骤一，在index=0处插入根结点的值
             root=root.right;//步骤二，遍历右子树
            }
            else{
                TreeNode tem=stack.pop();
                root=tem.left;//步骤三，遍历左子树
            }
        }
        return list;
    }
}
```
主要参考：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/die-dai-jie-fa-shi-jian-fu-za-du-onkong-jian-fu-za/