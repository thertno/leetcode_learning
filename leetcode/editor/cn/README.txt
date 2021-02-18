1.寻找重复的二叉树子树
    1.知道以自己为根的二叉树长的样子
        1.后序遍历，left+","+right+","+root.val;
    2.查询其它二叉树长的样子
        借助一个map，key：left+","+right+","+root.val; val：count
        如果count==1，加入list
2.[297]二叉树的序列化与反序列化
    1.序列化:前序遍历：root+","+left+","+right
    2.反序列化：第一个是root，构造root，
        root.left=递归
        root.right=递归