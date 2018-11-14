package leecode

import java.util.*

/**
 *
 * @author  doive
 * on 2018/11/5 14:12
 */
/*
给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) {
        return l2
    }
    if (l2 == null) {
        return l1
    }

    val result = ListNode(0)
    var lTemp1 = l1
    var lTemp2 = l2
    var current = result
    var more = 0
    while (lTemp1 != null || lTemp2 != null) {
        val sum = (lTemp1?.`val` ?: 0) + (lTemp2?.`val` ?: 0) + more
        more = sum / 10
        current.next = ListNode(sum % 10)
        current = current.next!!
        lTemp1 = lTemp1?.next
        lTemp2 = lTemp2?.next
    }
    return result.next
}

/**
 * 数组 to listNode
 */
private fun IntArray.arrayToNode(): ListNode? {
    val result = ListNode(0)
    var temp = result
    this.forEach { i ->
        temp.next = ListNode(i)
        temp = temp.next!!
    }
    return result.next
}

/**
 * 打印
 */
private fun ListNode?.print() {
    var temp = this
    val sb = StringBuffer("[")
    while (temp != null) {
        sb.append(temp.`val`).append(",")
        temp = temp.next
    }
    if (sb.length > 1) sb.deleteCharAt(sb.lastIndex)
    sb.append("]")
    println(sb)
}

/**
 * 相加
 */
private operator fun ListNode?.plus(l1: ListNode?) = addTwoNumber2(this, l1)

/**
 * 测试主程序
 */
fun main(args: Array<String>) {
    val node = intArrayOf(2, 1,5,7).arrayToNode() + intArrayOf(2,9,9).arrayToNode()
    node.print()
}

/**
 * 扩展，listNode 不以逆序存储
 * todo 实现两个不同位数
 */
fun addTwoNumber2(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1==null){
        return l2
    }
    val stack1 = Stack<Int>()
    var listNode1 = l1
    while (listNode1!=null){
        stack1.push(listNode1.`val`)
        listNode1 = listNode1.next
    }

    val stack2 = Stack<Int>()
    var listNode2 = l2
    while (listNode2!=null){
        stack2.push(listNode2.`val`)
        listNode2 = listNode2.next
    }
    var result :ListNode?= null
    var more = 0
    while (stack1.isNotEmpty()||stack2.isNotEmpty()){
        val value1 = if (stack1.isNotEmpty()) stack1.pop() else 0
        val value2 = if (stack2.isNotEmpty()) stack2.pop() else 0
        val temp = result
        result = ListNode((value1+value2+more)%10)
        result.next = temp
        more = (value1+value2)/10
    }
    return result
}