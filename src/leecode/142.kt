package leecode

/**
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * @author  doive
 * on 2019/6/13 15:19
 */
fun main() {
    fun detectCycle(head: ListNode?): ListNode? {
        head?.next?.next ?: return null
        var slow = head
        var fast = head
        var target = head
        var haveCycle = false
        while (slow?.next != null && fast?.next?.next != null) {
            slow = slow.next
            fast = fast.next?.next
            if (slow == fast) {
                haveCycle = true
                break
            }
        }
        //有环
        while (haveCycle) {
            if (target == slow) {
                return target
            }
            slow = slow?.next
            target = target?.next
        }
        return null
    }

    val head = ListNode(3)
    val second = ListNode(2)
    head.next = second
    second.next = head
    println("head :$head,s :$second")
    detectCycle(head).println()
}