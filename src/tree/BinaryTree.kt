package tree

/**
 * 二叉树
 * @author  doive
 * on 2019/1/24 17:30
 */
abstract class BinaryTree<V, N : IBinaryNode<V>>(var root: IBinaryNode<V>? = null) {
    /**
     * 插入节点
     */
    abstract fun insertNode(node: N): N?

    /**
     * 删除某节点
     */
    abstract fun deleteNode(node: N): N?


    /**
     * 前序遍历
     * 根-左-右
     */
    fun preOrderTraversal(node: IBinaryNode<V>? = root) {
        if (node != null) {
            print(" $node ")
            preOrderTraversal(node.getLeftNode())
            preOrderTraversal(node.getRigthNode())
        }
    }

    /**
     * 中序遍历
     */
    fun inOrderTraversal(node: IBinaryNode<V>? = root) {
        if (node != null) {
            preOrderTraversal(node.getLeftNode())
            print(" $node ")
            preOrderTraversal(node.getRigthNode())
        }
    }

    /**
     * 后序遍历
     */

    fun postOrderTraversal(node: IBinaryNode<V>? = root) {
        if (node != null) {
            preOrderTraversal(node.getLeftNode())
            preOrderTraversal(node.getRigthNode())
            print(" $node ")
        }
    }
}
