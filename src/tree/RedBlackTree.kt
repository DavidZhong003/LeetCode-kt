package tree

/**
 * 红黑树
 * @author  doive
 * on 2019/1/24 17:29
 */

const val Black = true

const val Red = false

/**
 * 红黑树节点
 */
class RedBlackNode<V : Comparable<V>>(private var v: V,
                                      var color: Boolean = Black,
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

}

class RedBlackTree<V : Comparable<V>> : BinaryTree<V,RedBlackNode<V>>() {
    override fun insertNode(node: RedBlackNode<V>): RedBlackNode<V>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteNode(node: RedBlackNode<V>): RedBlackNode<V>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun rotateLeft(node: RedBlackNode<V>?){

    }
}