package leecode

/**
 *
 * @author  doive
 * on 2019/6/13 14:19
 */
fun main() {
    /**
     * 快慢指针,一个走一步,一个走两步
     */
    fun hasCycle(head:ListNode?):Boolean{
        if (head?.next==null){
            return false
        }
        var slow = head
        var fast = head.next
        while (true){
            if (slow==fast){
                return true
            }
            if (fast?.next == null||fast.next?.next==null){
                return false
            }
            slow = slow?.next
            fast = fast.next?.next
        }
    }
}