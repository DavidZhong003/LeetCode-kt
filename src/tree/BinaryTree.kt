package tree

/**
 * 平衡二叉树以及红黑树
 * @author doive
 * on 2019/1/22 09:43
 */
/**
 * 节点
 * [value] 存储值
 * [parent] 父节点
 * [left] 左节点
 * [right] 右节点
 */
open class Node<V : Comparable<V>>(var value: V,
                                   var parent: Node<V>?=null,
                                   var left:Node<V>?=null,
                                   var right:Node<V>?=null){
    override fun toString(): String {
        return value.toString()
    }
}

/**
 * 二叉树
 */
class BinaryTree<V : Comparable<V>>(var root:Node<V>? = null) {
    /**
     * 前序遍历DLR
     * 根-左-右
     */
    fun preOrderTraversal(){
        preOrderTraversal(root)
    }

    private fun preOrderTraversal(node: Node<V>?){
        if (node!=null){
            print("$node  ")
            preOrderTraversal(node.left)
            preOrderTraversal(node.right)
        }
    }
    /**
     * 中序遍历
     * 左-根-右
     */
    fun inOrderTraversal(){
        inOrderTraversal(root)
    }

    private fun inOrderTraversal(node: Node<V>?){
        if (node!=null){
            inOrderTraversal(node.left)
            print("$node  ")
            inOrderTraversal(node.right)
        }
    }
    /**
     * 后序遍历
     * 左-右-根
     */
    fun postOrderTraversal(){
        postOrderTraversal(root)
    }

    private fun postOrderTraversal(node: Node<V>?){
        if (node!=null){
            postOrderTraversal(node.left)
            postOrderTraversal(node.right)
            print("$node  ")
        }
    }

    // 旋转操作区域


}