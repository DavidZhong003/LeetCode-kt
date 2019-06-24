package leecode

/**
 * 230. 二叉搜索树中第K小的元素
 * @author  doive
 * on 2019/6/24 10:30
 */
fun main() {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        fun ldr(root: TreeNode?, list: MutableList<Int>) {
            if (root?.left != null) {
                ldr(root.left, list)
            }
            if (root != null) {
                list.add(root.`val`)
            }
            if (root?.right != null) {
                ldr(root.right, list)
            }
        }
        val list = mutableListOf<Int>()
        ldr(root, list)
        return list[k-1]
    }

    val tree = TreeNode(3).apply {
        left = TreeNode(1).apply {
            right = TreeNode(2)
        }
        right = TreeNode(4)
    }

    val tree2 = TreeNode(5).apply {
        left = TreeNode(3).apply {
            left = TreeNode(2).apply {
                left = TreeNode(1)
            }
            right = TreeNode(4)
        }
        right = TreeNode(6)
    }

    kthSmallest(tree,1).println()
    kthSmallest(tree2,3).println()
}