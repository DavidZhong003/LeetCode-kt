package leecode

/**
 *
 * @author  doive
 * on 2019/6/12 14:48
 */
fun main() {
    /**
     * 左or 右子树
     * 左+
     */

    var max = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        fun getMax(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }
            val left = Math.max(0, getMax(root.left))
            val right = Math.max(0, getMax(root.right))
            max = Math.max(max, left + right + root.`val`)
            return Math.max(left, right) + root.`val`
        }
        getMax(root)
        return max

    }

    val root = TreeNode(-8).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }

    maxPathSum(root).println()

}
