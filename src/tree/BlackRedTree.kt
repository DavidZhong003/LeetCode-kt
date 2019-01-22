package tree

import kotlin.test.todo

/**
 * 平衡二叉树以及红黑树
 * @author doive
 * on 2019/1/22 09:43
 */

const val BLACK = true

const val RED = false

/**
 * 节点
 * [value] 存储值
 * [parent] 父节点
 * [left] 左节点
 * [right] 右节点
 * [color] 颜色默认为黑色
 */
open class Node<V : Comparable<V>>(var value: V,
                                   var parent: Node<V>? = null,
                                   var left: Node<V>? = null,
                                   var right: Node<V>? = null, var color: Boolean = BLACK) {
    override fun toString(): String {
        return "value: $value , color : ${if (color) "black" else "red"}"
    }
}

/**
 * 二叉树
 */
open class BlackRedTree<V : Comparable<V>>(var root: Node<V>? = null) {
    /**
     * 前序遍历DLR
     * 根-左-右
     */
    fun preOrderTraversal() {
        preOrderTraversal(root)
    }

    private fun preOrderTraversal(node: Node<V>?) {
        if (node != null) {
            print("$node  ")
            preOrderTraversal(node.left)
            preOrderTraversal(node.right)
        }
    }

    /**
     * 中序遍历
     * 左-根-右
     */
    fun inOrderTraversal() {
        inOrderTraversal(root)
    }

    private fun inOrderTraversal(node: Node<V>?) {
        if (node != null) {
            inOrderTraversal(node.left)
            print("$node  ")
            inOrderTraversal(node.right)
        }
    }

    /**
     * 后序遍历
     * 左-右-根
     */
    fun postOrderTraversal() {
        postOrderTraversal(root)
    }

    private fun postOrderTraversal(node: Node<V>?) {
        if (node != null) {
            postOrderTraversal(node.left)
            postOrderTraversal(node.right)
            print("$node  ")
        }
    }

    // 旋转操作区域
    /**
     * 左旋某个节点x
     *           root               root
     *          /                   /
     *         p                  r1
     *        / \                /  \
     *       l1  r1    -->     p   nr
     *          / \            / \
     *        nl  nr         l1  nr
     * [node] 旋转的节点
     */
    fun rotateLeft(node: Node<V>?) {
        node ?: return
        val r = node.right
        val rL = r?.left
        rL?.parent = node

        r?.parent = node.parent
        when {
            node.parent == null -> root = r
            node.parent?.left == node -> node.parent?.left = r
            else -> node.parent?.right = r
        }

        r?.left = node
        node.parent = r

    }

    /**
     * 左旋某个节点x
     *           root               root
     *          /                   /
     *         p                  r1
     *        / \                /  \
     *       l1  r1    <--     p   nr
     *          / \            / \
     *        nl  nr         l1  nr
     * [node] 旋转的节点
     */
    fun rotateRight(node: Node<V>?) {
        node ?: return
        val l = node.left
        val lR = l?.right

        lR?.parent = node

        l?.parent = node.parent
        when {
            node.parent == null -> root = l
            node.parent?.left == node -> node.parent?.left = l
            else -> node.parent?.right = l
        }

        node.parent = l
        l?.right = node
    }

    /**
     * 查找最大节点
     */

    fun maxNode() = maxNode(root)

    /**
     * 最大节点
     */
    private fun maxNode(node: Node<V>?): Node<V>? {
        var result = node
        while (result?.right != null) {
            result = result.right
        }
        return result
    }


    /**
     * 查找最小节点
     */

    fun minNode() = minNode(root)

    /**
     * 最小节点
     */
    private fun minNode(node: Node<V>?): Node<V>? {
        var result = node
        while (result?.left != null) {
            result = result.left
        }
        return result
    }

    /**
     * node 的后继节点(大于node的最小节点)
     * @param [node] 节点
     */
    fun successor(node: Node<V>?): Node<V>? {
        //如果有右节点
        if (node?.right != null) {
            return minNode(node.right)
        }
        //如果为左节点,后继节点为父节点
        //如果为右节点,继续寻找父节点
        var result = node?.parent
        var temp = node
        while (result != null && (result.right == temp)) {
            temp = result
            result = temp.parent
        }
        return result
    }

    /**
     * node 的前驱节点(小于node的最大节点)
     */
    fun predecessor(node: Node<V>?): Node<V>? {
        //如果有左节点
        if (node?.left != null) {
            return maxNode(node.left)
        }
        var result = node?.parent
        var temp = node
        while (temp != null && (result?.left == temp)) {
            temp = result
            result = temp.parent
        }
        return result
    }

    /**
     * 添加
     */

    fun insert(v: V) {
        val node = Node(v)
        insert(node)
    }

    /**
     * 插入某个节点
     * @param [node] 插入的节点
     * @return 旧节点,null
     *
     */
    private fun insert(node: Node<V>?) :Node<V>?{
        if (this.root==null){
            root = node
            return null
        }
        //1. 寻找插入的位置
         todo {  }

        //2. 判断插入其左还是右节点

        //3. 修复红黑树

        return null
    }

}

object Test {
    private val a = intArrayOf(10, 40, 30, 60, 90, 70, 20, 50, 80)

    @JvmStatic
    fun main(args: Array<String>) {

    }
}


