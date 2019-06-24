package leecode

/**
 * 二叉搜索树的最近公共祖先
 * @author  doive
 * on 2019/6/24 11:28
 */
fun main() {
    /**
     * 二叉搜索树特点
     * 左<根<右
     */
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {
        root ?: return null
        return when {
            (root.`val` - p.`val`) * (root.`val` - q.`val`) < 0 -> root
            root.`val` < p.`val` && root.`val` < q.`val` -> lowestCommonAncestor(root.right, p, q)
            else -> lowestCommonAncestor(root.left, p, q)
        }
    }
}
