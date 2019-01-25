package tree

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
                                   var right: Node<V>? = null, var color: Boolean = BLACK) : TreePrintUtil.TreeNode{
    override fun getPrintInfo(): String {
        return "[$value]${if (color) "b" else "r"}"
    }

    override fun getLeftChild(): TreePrintUtil.TreeNode? {
        return left
    }

    override fun getRightChild(): TreePrintUtil.TreeNode? {
        return right
    }

    override fun toString(): String {
        return "[$value]${if (color) "b" else "r"}"
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
            print("$node  ||")
            preOrderTraversal(node.left)
            preOrderTraversal(node.right)
        } else {
            print("null ||")
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
     * 左旋某个节点x,右孩子为支点
     *           root               root
     *          /                   /
     *         p                  r1
     *        / \                /  \
     *       l1  r1    -->     p   nr
     *          / \            / \
     *        nl  nr         l1  nl
     *  主要处理4个节点之前关系,node,node右节点,node父节点,node右左节点
     * [node] 旋转的节点
     */
    private fun rotateLeft(node: Node<V>?) {
        node ?: return
        // 处理3个

        val r = node.right
        node.right = r?.left

        r?.left?.parent = node
        // 处理 p-pp关系
        when {
            node.parent == null -> root = r
            node.isLeft() -> node.parent!!.left = r
            else -> node.parent!!.right = r
        }

        r?.left = node
        node.parent = r
    }

    /**
     * 右旋某个节点x,左孩子为支点
     *           root               root
     *          /                   /
     *         p                  node
     *        / \                /  \
     *       l1  node    <--    p   nr
     *          / \            / \
     *        nl  nr         l1  nr
     * [node] 旋转的节点
     */
    private fun rotateRight(node: Node<V>?) {
        node ?: return
        val p = node.left
        node.left = p?.right
        p?.right?.parent = node

        when{
            node.parent==null -> root = p
            node.isLeft() -> node.parent!!.left = p
            else -> node.parent!!.right = p
        }
        p?.right = node
        node.parent = p
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
    private fun insert(node: Node<V>): Node<V>? {
        if (this.root == null) {
            root = node
            return null
        }
        //1. 寻找插入的位置
        var insertParent: Node<V>? = null
        var x = this.root
        while (x != null) {
            insertParent = x
            val cmp = node.value.compareTo(x.value)
            when {
                cmp < 0 -> x = insertParent.left
                cmp > 0 -> x = insertParent.right
                else -> {
                    insertParent.value = node.value
                    return x
                }
            }
        }
        node.parent = insertParent
        //2. 判断插入其左还是右节点
        if (insertParent != null) {
            val cmp = node.value.compareTo(insertParent.value)
            if (cmp < 0) {
                insertParent.left = node
            } else {
                insertParent.right = node
            }
        } else {
            root = node
        }
        //3. 修复红黑树
        fixAfterInsert(node)
        TreePrintUtil.pirnt(root)
        println("====================================================")
        return null
    }

    private fun fixAfterInsert(n: Node<V>?) {
        n?.color = RED
        var node = n
        while (node != null && node != root && node.parent?.color == RED) {

            val uncleNode = node.getUncleNode()
            // 父节点为左节点
            if (node.parent.isLeft()) {
                if (uncleNode.isRed()) {
                    //叔节点为红色

                    //设置父节点为黑色
                    node.parent.setBlack()
                    //叔节点为黑色
                    uncleNode.setBlack()
                    // 祖父节点为黑色
                    node.parent?.parent.setBlack()
                    // 设置为祖父节点
                    node = node.parent?.parent
                } else if (uncleNode.isBlack()) {
                    // 叔节点为黑色

                    // 改节点为右节点
                    if (node.isRight()) {
                        // 设置为父节点
                        node = node.parent
                        // 左旋
                        rotateLeft(node)
                    }
                    // 父节点设置黑色
                    node?.parent.setBlack()
                    // 祖父节点设置红色
                    node?.parent?.parent.setRed()
                    // 右旋
                    rotateRight(node?.parent?.parent)
                }
            } else if (node.parent.isRight()) {
                // 父节点为右节点

                // 叔节点为红色
                if (uncleNode.isRed()) {

                    // 父节点设置黑色
                    node.parent.setBlack()
                    //叔节点设置黑色
                    uncleNode.setBlack()
                    // 祖父节点设置黑色
                    node.parent?.parent.setBlack()
                    // 设置成祖父节点
                    node = node.parent?.parent
                } else if (uncleNode.isBlack()) {
                    //叔节点为黑色

                    // 为左节点
                    if (node.isLeft()) {
                        // 设置为父节点
                        node = node.parent
//                                右旋
                        rotateRight(node)
                    }
//                    设置父节点为黑色
                    node?.parent.setBlack()
                    //设置祖父节点为红色
                    node?.parent?.parent.setRed()
                    //左旋
                    rotateLeft(node?.parent?.parent)
                }
            }
        }
        //设置根为黑色

        root?.color = BLACK
    }

}


/**
 * 设置一个节点为红色
 */
fun <V : Comparable<V>> Node<V>?.setRed() {
    this?.color = RED
}

/**
 * 设置一个节点为红色
 */
fun <V : Comparable<V>> Node<V>?.setBlack() {
    this?.color = BLACK
}

/**
 * 判断一个节点是否是红色
 */
fun <V : Comparable<V>> Node<V>?.isRed() = if (this != null) this.color == RED else false

/**
 * 判断一个节点是否是黑色
 * 空节点默认为黑色
 */
fun <V : Comparable<V>> Node<V>?.isBlack() = if (this != null) this.color == BLACK else true

/**
 * 判断是否是左节点
 */
fun <V : Comparable<V>> Node<V>?.isLeft(): Boolean {
    if (this != null && this == this.parent?.left) {
        return true
    }
    return false
}

/**
 * 判断是否是右节点
 */
fun <V : Comparable<V>> Node<V>?.isRight(): Boolean {
    if (this != null && this == this.parent?.right) {
        return true
    }
    return false
}

/**
 * 获取叔节点
 */
fun <V : Comparable<V>> Node<V>?.getUncleNode(): Node<V>? {
    if (this.isRight()) {
        return this?.parent?.left
    }
    if (this.isLeft()) {
        return this?.parent?.right
    }
    return null
}

object Test {
    private val a = intArrayOf(10, 40, 30, 60, 90, 70, 20, 50, 80)

    @JvmStatic
    fun main(args: Array<String>) {
        val tree = BlackRedTree<Int>()
        a.forEach {
            println("添加的节点$it")
            tree.insert(it)
        }
        TreePrintUtil.pirnt(tree.root)
    }
}


