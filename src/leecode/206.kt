package leecode

/**
 * 反转链表
 * @author  doive
 * on 2019/6/20 15:38
 */
fun main() {
    /**
     * 迭代实现
     */
    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next==null){
            return head
        }
        val result = ListNode(0)
        var temp = head
        var next: ListNode?
        while (temp!=null){
            next = temp.next
            temp.next = result.next
            result.next = temp
            temp = next
        }
        return result.next
    }

    /**
     * 反转链表 递归
     */
    fun reverseListRecursive(head:ListNode?):ListNode?{
        if (head?.next==null){
            return head
        }
        val next = reverseListRecursive(head.next)
        head.next?.next = head
        head.next = null
        return next
    }
//    reverseList(intArrayOf().arrayToNode()).print()
//    reverseList(intArrayOf(1).arrayToNode()).print()
//    reverseList(intArrayOf(1,2,3,4).arrayToNode()).print()
    reverseListRecursive(intArrayOf(1,2,3,4,5).arrayToNode()).print()
}