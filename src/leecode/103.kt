package leecode

import java.util.LinkedList



/**
 *
 * @author  doive
 * on 2020/4/30 14:20
 */
fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()
    if (root == null) {
        return result
    }
    val queue = LinkedList<TreeNode>()
    queue.addFirst(root)
    var leftFirst = true
    var level = 0
    while (queue.isNotEmpty()) {
        if (level > result.lastIndex) {
            result.add(mutableListOf())
        }
        val qSize = queue.size
        (0 until qSize).forEach { _ ->
            val node = queue.poll() ?: return@forEach
            result[level].add(node.`val`)
            val l = node.left
            val r = node.right
            if (l != null) {
                queue.offer(l)
            }
            if (r != null) {
                queue.offer(r)
            }
        }
        if (!leftFirst) {
            result[level].reverse()
        }
        level++
        leftFirst = !leftFirst
    }
    return result
}

/**
 * 递归实现
 */
fun zigzagLevelOrderRecursive(root: TreeNode?): List<List<Int>> {
    fun zigzagLevelOrderRecursive(root: TreeNode?, level: Int, leftFirst: Boolean,
                                  list: MutableList<LinkedList<Int>>): List<List<Int>> {
        if (root==null){
            return emptyList()
        }
        if (level>=list.size){
            list.add(LinkedList())
        }
        if (leftFirst) list[level].addLast(root.`val`) else list[level].addFirst(root.`val`)
        zigzagLevelOrderRecursive(root.left, level+1, !leftFirst, list)
        zigzagLevelOrderRecursive(root.right,level+1,!leftFirst, list)
        return list
    }

    val result = mutableListOf<LinkedList<Int>>()
    if (root == null) {
        return result
    }
    return zigzagLevelOrderRecursive(root,0,true,result)
}

fun main() {
    zigzagLevelOrder(TreeUtils.createTree(3, 9, 20, null, null, 15, 7)).println()
    zigzagLevelOrderRecursive(TreeUtils.createTree(1,2,3,4,null,null,5)).println()
}