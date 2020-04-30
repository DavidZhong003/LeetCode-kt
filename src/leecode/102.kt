package leecode

import java.util.ArrayList
import java.util.LinkedList



/**
 *
 * @author  doive
 * on 2020/4/30 11:06
 */
fun levelOrder(root: TreeNode?): List<List<Int?>> {
    val result = ArrayList<ArrayList<Int>>()
    if (root == null) {
        return result
    }
    // 存储一层的元素
    val queue = LinkedList<TreeNode>()
    queue.offer(root)
    var level = 0
    while (!queue.isEmpty()) {
        if (result.size - 1 < level) {
            result.add(ArrayList())
        }
        val levelSize = queue.size
        for (i in 0 until levelSize) {
            val node = queue.poll()
            if (node != null) {
                result[level].add(node.`val`)
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
        }
        level++
    }
    return result
}

fun levelOrderRecursive(root: TreeNode?):List<List<Int?>>{
    fun levelOrderRecursive(root: TreeNode?,level:Int,list:ArrayList<ArrayList<Int>>):List<List<Int?>>{
        if (root==null){
            return list
        }
        if (level>list.size-1){
            list.add(ArrayList())
        }
        list[level].add(root.`val`)
        levelOrderRecursive(root.left,level+1, list)
        levelOrderRecursive(root.right, level+1, list)
        return list
    }
    if (root ==null){
        return  emptyList()
    }
    return levelOrderRecursive(root,0,ArrayList<ArrayList<Int>>())
}

fun main() {
    levelOrderRecursive(TreeUtils.createTree(3,9,20,null,null,15,7)).println()
}