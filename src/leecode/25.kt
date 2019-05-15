package leecode

import java.util.Stack

/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * @author  doive
 * on 2019/3/13 16:43
 */
fun main() {

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        // k 是一个正整数
        if (head?.next == null || k <= 1) {
            return head
        }
        val stack = Stack<ListNode>()
        var result: ListNode? = null
        var resultLast: ListNode? = null
        var h = head
        while (h != null) {
            val next = h.next
            h.next = null
            stack.push(h)
            h = next
            if (stack.size == k) {
                val r: ListNode? = stack.pop()
                var rl = r
                while (stack.isNotEmpty()) {
                    val node = stack.pop()
                    rl?.next = node
                    rl = rl?.next
                }

                if (result == null) {
                    result = r
                } else {
                    resultLast?.next = r

                }
                resultLast = r
                while (resultLast?.next != null) {
                    resultLast = resultLast.next
                }

            }
        }
        if (result == null) {
            while (stack.isNotEmpty()) {
                val node = stack.pop()
                if (result==null){
                    result = node
                    resultLast = node
                }else{
                    node.next = result
                    result = node
                }
            }
        }
        while (result != null && stack.isNotEmpty()) {
            val node = stack.pop()
            val next = resultLast?.next
            resultLast?.next = node
            node.next = next
        }
        // 当前需要反转的链表长度
        return result
    }

    reverseKGroup(intArrayOf(1, 2).arrayToNode(), 3).print()
//    reverseKGroup(intArrayOf(1, 2, 3, 4).arrayToNode(), 4).print()
//    reverseKGroup(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8).arrayToNode(), 3).print()
//    reverseKGroup(intArrayOf(1, 2, 3, 4, 5, 6, 8, 9).arrayToNode(), 1).print()
}

/**
 * 反转一个链表
 */
private fun reverseNode(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    var h: ListNode? = head
    var result: ListNode? = null
    var next: ListNode?
    while (h != null) {
        next = h.next
        h.next = result
        result = h
        h = next
    }

    return result
}

/**
 * 反转链表通过递归
 */
private fun reverseNodeByRecursive(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    val next = head.next
    head.next = null
    val result = reverseNodeByRecursive(next)
    next?.next = head
    return result
}