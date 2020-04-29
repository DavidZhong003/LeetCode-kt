package leecode

/**
 *
 * 给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
1
\
2
/
3

输出: [1,3,2]
 * on 2020/4/29 11:23
 */

fun inorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) {
        return emptyList()
    }
    val result = mutableListOf<Int>()
    result.addAll(inorderTraversal(root.left))
    result.add(root.`val`)
    result.addAll(inorderTraversal(root.right))
    return result
}

// 非递归形式

