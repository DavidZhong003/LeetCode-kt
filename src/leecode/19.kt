package leecode

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @author  doive
 * on 2019/3/1 14:43
 */
fun main(args: Array<String>) {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        head?:return null
        if (n<=0){
            return head
        }
        if (head.next==null&&n==1){
            return null
        }
        var first  = head
        var target = head
        var index = 0
        var secondGo = false
        while (first?.next!=null){
            first = first.next
            index++
            if (index==n){
                secondGo = true
            }
            if (secondGo){
                target = target?.next
            }
        }
        // 删除target
        val next = target?.next
        if (next!=null){
            target!!.`val` = next.`val`
            target.next = next.next
        }
        return head
    }
}