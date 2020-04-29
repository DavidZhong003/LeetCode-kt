package tree

/**
 * 红黑树
 * @author  doive
 * on 2019/1/24 17:29
 */

const val Black = true

const val Red = false

enum class Color {
    Red, Black
}

/**
 * 红黑树节点
 */
class RedBlackNode<V : Comparable<V>>(private var v: V,
                                      var color: Color = Color.Black,
                                      var left: RedBlackNode<V>? = null,
                                      var right: RedBlackNode<V>? = null,
                                      var parents: RedBlackNode<V>? = null
) : IBinaryNode<V>, TreePrintUtil.TreeNode {
    override fun getPrintInfo(): String {
        return "$v : $color"
    }

    override fun getLeftChild(): TreePrintUtil.TreeNode? = left

    override fun getRightChild(): TreePrintUtil.TreeNode? = right

    override fun getValue(): V = v

    override fun getLeftNode(): IBinaryNode<V>? = left

    override fun getRigthNode(): IBinaryNode<V>? = right

    override fun getParentsNode(): IBinaryNode<V>? = parents
    /**
     * 左旋
     */
    fun leftHanded() {
        val p = parents
        val r = right
        val isLeft = this == parents?.left
        // 右子节点变成父节点
        parents = r
        r?.parents = p
        if (p != null) {
            if (isLeft) {
                p.left = r
            } else {
                p.right = r
            }
        }
        // 右子节点的左节点变成右节点
        right = r?.left
        r?.left?.parents = this
        r?.left = this
    }

    /**
     * 右旋
     */
    fun rightHanded() {
        val p = parents
        val l = left
        val isLeft = this == parents?.left
        // 左节点变成父节点
        parents = l
        l?.parents = p
        if (p != null) {
            if (isLeft) {
                p.left = l
            } else {
                p.right = l
            }
        }
        // 左节点右节点变成左节点
        left = l?.right
        l?.right?.parents = this
        l?.right = this
    }


}
