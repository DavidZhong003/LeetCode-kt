package leecode

/**
 *
 * @author  doive
 * on 2019/3/13 15:27
 */
fun main() {


    fun swapPairs(head: ListNode?): ListNode? {
        // 长度为0
        if (head?.next == null){
            return head
        }
        val result :ListNode?= head.next
        head.next = swapPairs(result?.next)
        result?.next = head
        return result
    }
    swapPairs(intArrayOf().arrayToNode()).print()
    swapPairs(intArrayOf(1).arrayToNode()).print()
    swapPairs(intArrayOf(1,2).arrayToNode()).print()
    swapPairs(intArrayOf(1,2,3).arrayToNode()).print()
    swapPairs(intArrayOf(1,2,3,4).arrayToNode()).print()

}