package leecode

import java.util.Stack

/**
 * 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * @author  doive
 * on 2019/6/19 16:03
 */
fun main() {

}

class MinStack {
    private val minStack = Stack<Int>()

    private val stack = Stack<Int>()

    fun push(x: Int) {
        stack.push(x)
        if (minStack.isEmpty()) {
            minStack.push(x)
        } else {
            if (x <= minStack.peek()) {
                minStack.push(x)
            }
        }
    }

    fun pop() {
        val pop = stack.pop()
        if (pop == minStack.peek()) {
            minStack.pop()
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }

}