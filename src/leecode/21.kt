package leecode

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author  doive
 * on 2019/3/2 20:08
 */

fun main(args: Array<String>) {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val head = ListNode(0)
        var current :ListNode = head
        var temp1 = l1
        var temp2 = l2
        while (temp1!=null&&temp2!=null){
            val value1 = temp1.`val`
            val value2 = temp2.`val`
            if (value1<value2){
                current.next = ListNode(value1)
                current = current.next!!
                temp1 = temp1.next
            }else{
                current.next = ListNode(value2)
                current = current.next!!
                temp2 = temp2.next
            }
        }
        if (temp1==null){
            current.next = temp2
        }
        if (temp2==null){
            current.next = temp1
        }
        return head.next
    }
    // 正常
    mergeTwoLists(intArrayOf(1,2,4).arrayToNode(), intArrayOf(1,3,4).arrayToNode()).print()
    // l1 null
    mergeTwoLists(intArrayOf().arrayToNode(),
                  intArrayOf(1,3,4).arrayToNode()).print()
    // double null
    mergeTwoLists(intArrayOf().arrayToNode(),
                  intArrayOf().arrayToNode()).print()
}