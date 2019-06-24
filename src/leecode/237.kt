package leecode

/**
 *
 * @author  doive
 * on 2019/6/24 14:44
 */
fun main() {
    fun deleteNode(node:ListNode?){
        node?.`val` = node?.next!!.`val`
        node.next=node.next!!.next
    }
}