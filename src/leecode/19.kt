package leecode

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @author  doive
 * on 2019/3/1 14:43
 */
fun main(args: Array<String>) {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        head ?: return null
        if (n <= 0) {
            return head
        }
        if (n==1&&head.next==null){
            return null
        }
        var first = head
        // 删除目标
        var target: ListNode? = null
        var step = 0
        while (first?.next != null) {
            first = first.next
            step++
            if (target != null) {
                target = target.next
            }
            if (step == n) {
                target = head
            }
        }
        // 如果n大于长度
        if (step < n-1) {
            return head
        }
        //如果是要删除头节点
        if (target == null) {
            return head.next
        }
        // 删除后面那个
        val del = target.next
        if (del != null) {
            target.next = del.next
        }
        return head
    }

    removeNthFromEnd(intArrayOf(1).arrayToNode(), 1).print()
    //尾节点
    removeNthFromEnd(intArrayOf(1, 2).arrayToNode(), 1).print()
    // 删除头
    removeNthFromEnd(intArrayOf(1, 2).arrayToNode(), 2).print()
    // 中间
    removeNthFromEnd(intArrayOf(1, 2, 3).arrayToNode(), 2).print()
}