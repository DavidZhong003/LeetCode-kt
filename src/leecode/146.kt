package leecode

/**
 *
 * @author  doive
 * on 2019/6/14 14:21
 */
class LRUCache(capacity: Int) {

    private class Node(var key: Int, var value: Int) {
        var pre: Node? = null
        var next: Node? = null
    }

    private var head: Node? = null

    private var tail: Node? = null

    private val map = HashMap<Int, Node>(capacity)

    private val maxSize = capacity

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        moveToHead(node)
        return node.value
    }

    private fun moveToHead(node: Node) {
        when (node) {
            head -> return
            tail -> {
                tail?.pre?.next = null
                tail = tail?.pre
            }
            else -> {
                node.pre?.next = node.next
                node.next?.pre = node.pre
            }
        }
        node.pre = null
        node.next = head
        head?.pre = node
        head = node
    }

    fun put(key: Int, value: Int) {
        val old = map[key]
        if (old == null) {
            // 插入
            val new = Node(key, value)
            addToHead(new)
            map[key] = new
            checkSize()
        } else {
            // 更新
            old.value = value
            moveToHead(old)
        }
    }

    private fun checkSize() {
        while (map.size > maxSize) {
            tail?.pre?.next = null
            map.remove(tail?.key)
            tail = tail?.pre
        }
    }

    private fun addToHead(new: Node) {
        if (map.size == 0) {
            head = new
            tail = new
        } else {
            new.next = head
            head?.pre = new
            head = new
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
fun main() {
    val cache = LRUCache(2).apply {
        put(1, 1).println()
        put(2, 2).println()
        get(1).println()
        put(3, 3).println()
        get(2).println()
        put(4, 4).println()
        get(1).println()
        get(3).println()
        get(4).println()
    }

    LRUCache(1).apply {
        put(1, 1)
        put(2, 2)
        get(1).println()

    }
}