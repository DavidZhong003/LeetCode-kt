package leecode

/**
 * 合并K个排序链表
 * @author  doive
 * on 2019/3/4 18:14
 */
fun main(args: Array<String>) {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        /**
         * 合并两个有序链表,同21
         */
        fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
            val head = ListNode(0)
            var current: ListNode = head
            var temp1 = l1
            var temp2 = l2
            while (temp1 != null && temp2 != null) {
                val value1 = temp1.`val`
                val value2 = temp2.`val`
                if (value1 < value2) {
                    current.next = ListNode(value1)
                    current = current.next!!
                    temp1 = temp1.next
                } else {
                    current.next = ListNode(value2)
                    current = current.next!!
                    temp2 = temp2.next
                }
            }
            if (temp1 == null) {
                current.next = temp2
            }
            if (temp2 == null) {
                current.next = temp1
            }
            return head.next
        }

        if (lists.isEmpty()) {
            return null
        }
        var s = 0

        var e = lists.lastIndex

        var currentSize = e-s+1


        while (currentSize>1){
            while (s<e){
                lists[s] = mergeTwoLists(lists[s],lists[e])
                s++
                e--
                if (s==e||s>e){
                    s = 0
                    currentSize = e-s+1
                }
            }
        }
        return lists[0]
    }

    mergeKLists(arrayOf(intArrayOf().arrayToNode(),
                        intArrayOf(1).arrayToNode())
    ).print()

    mergeKLists(arrayOf(intArrayOf(1).arrayToNode(),
                        intArrayOf().arrayToNode())
    ).print()

    mergeKLists(arrayOf(intArrayOf(0,1,2,3).arrayToNode(),
                        intArrayOf(1,3,4,5).arrayToNode(),intArrayOf(1,2,3,4).arrayToNode())
    ).print()
}