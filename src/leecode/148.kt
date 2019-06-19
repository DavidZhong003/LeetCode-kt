package leecode

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * @author  doive
 * on 2019/6/19 15:15
 */
fun main() {
    fun merge(left: ListNode?, right: ListNode?): ListNode? {
        val result = ListNode(0)
        var l = left
        var r = right
        var temp = result
        while (l != null && r != null) {
            while (l != null && l.`val` <= r.`val`) {
                temp.next = ListNode(l.`val`)
                temp = temp.next!!
                l = l.next
            }
            while (l != null && r != null && r.`val` <= l.`val`) {
                temp.next = ListNode(r.`val`)
                temp = temp.next!!
                r = r.next
            }
        }
        if (l!=null){
            temp.next = l
        }else if (r!=null){
            temp.next = r
        }
        return result.next
    }

    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val mid = head.findMid()
        val left = sortList(mid?.next)
        mid?.next = null
        val right = sortList(head)

        return merge(left, right)
    }

    sortList(intArrayOf(4,2,1,2,3).arrayToNode()).print()
}

private fun ListNode.findMid(): ListNode? {
    var fast: ListNode? = this.next
    var slow: ListNode? = this
    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next

    }
    return slow
}
