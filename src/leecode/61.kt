package leecode

/**
 * 61. 旋转链表
 * @author  doive
 * on 2019/6/10 16:21
 */
fun main() {

    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null || k <= 0) {
            return head
        }
        var length = 1
        var temp = head
        while (temp?.next != null) {
            length++
            temp = temp.next
        }
        val tailNode: ListNode = temp!!
        if (k % length == 0) {
            return head
        }
        var breakPoint = length - k % length - 1
        temp = head
        while (breakPoint > 0) {
            breakPoint--
            temp = temp?.next
        }
        val newTail = temp!!
        val newHead = temp.next!!
        newTail.next = null
        tailNode.next = head
        return newHead
    }
//    rotateRight(intArrayOf().arrayToNode(), 6).print()
//    rotateRight(intArrayOf(1, 2, 3, 4, 5).arrayToNode(), 0).print()
//    rotateRight(intArrayOf(1, 2, 3, 4, 5).arrayToNode(), 1).print()
    rotateRight(intArrayOf(1, 2, 3, 4, 5).arrayToNode(), 5).print()
//    rotateRight(intArrayOf(1, 2, 3, 4, 5).arrayToNode(), 6).print()

}