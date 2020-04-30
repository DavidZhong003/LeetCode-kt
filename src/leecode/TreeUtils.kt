package leecode

import java.util.LinkedList



/**
 *
 * @author  doive
 * on 2020/4/30 10:19
 */
object TreeUtils {
    // 非递归形式

    fun createTree(vararg nodes: Int?, buildTree: ((nodes: Array<out Int?>) -> TreeNode?) = {floorBuilder(it)}): TreeNode? {
        if (nodes.isEmpty() || nodes.first() == null) {
            return null
        }
        ///构建树
        return buildTree(nodes)
    }

    private fun floorBuilder(list:Array<out Int?>):TreeNode?{
        if (list.isEmpty() || list.first() == null) {
            return null
        }
        val numbsQueue = LinkedList(list.toList())
        val nodesQueue = LinkedList<TreeNode?>()
        val  root = TreeNode(numbsQueue.poll()!!)
        nodesQueue.offer(root)
        while (numbsQueue.isNotEmpty()&&nodesQueue.isNotEmpty()){
            val  temp=nodesQueue.poll()
            if (temp!=null){
                val left = numbsQueue.poll()
                val right = numbsQueue.poll()
                temp.left = if (left!=null) TreeNode(left) else null
                nodesQueue.offer(temp.left)
                temp.right = if (right!=null) TreeNode(right) else null
                nodesQueue.offer(temp.right)
            }
        }
        return root
    }

    private fun  maxLevel(node: TreeNode?): Int {
        return if (node == null) 0 else Math.max(maxLevel(node.left),
                                                 maxLevel(node.right)) + 1

    }

    fun printNode(root:TreeNode?){

    }

}