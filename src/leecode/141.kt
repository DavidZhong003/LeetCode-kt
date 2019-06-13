package leecode

/**
 *
 * @author  doive
 * on 2019/6/13 14:19
 */
fun main() {
    /**
     * 快慢指针
     * 一个走一步,一个走两步
     */
    fun hasCycle(head: ListNode?): Boolean {
        if (head?.next == null) {
            return false
        }
        var slow = head
        var fast = head
        while (fast?.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (slow == fast) {
                return true
            }
        }
        return false
    }
}