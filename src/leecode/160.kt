package leecode

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * @author  doive
 * on 2019/6/20 14:19
 */
fun main() {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        //构成一个环形链表
        if (headA == null || headB == null) return null
        var tempB = headB
        while (tempB?.next != null) {
            tempB = tempB.next
        }
        tempB?.next = headB
        //快慢指针寻找环点
        var slow: ListNode? = headA
        var fast: ListNode? = headB
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (slow == fast) {
                fast = headA
                while (fast != slow) {
                    fast = fast?.next
                    slow = slow?.next
                }
                tempB?.next = null
                return fast
            }
        }
        tempB?.next = null
        return null
    }

    val headA = intArrayOf(1,2,3).arrayToNode()
    val headB = intArrayOf(4,5,6).arrayToNode()
    val t = intArrayOf(7,8,9).arrayToNode()
    headA.last()?.next = t
    headB.last()?.next = t
    getIntersectionNode(headA,headB).print()

}

fun ListNode?.last() :ListNode?{
    this?:return null
    var r = this
    while (r?.next!=null){
        r = r.next
    }
    return r
}