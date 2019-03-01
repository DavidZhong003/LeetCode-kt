package leecode

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * @author  doive
 * on 2019/3/1 16:01
 */
fun main(args: Array<String>) {
    fun isValid(s: String): Boolean {
        fun Char.isLeft() = this == '(' || this == '[' || this == '{'
        fun Char.isClosure(other: Char): Boolean {
            when (other) {
                ')' -> return this == '('
                ']' -> return this == '['
                '}' -> return this == '{'
            }
            return false
        }
        if (s.isEmpty()) {
            return true
        }
        val leftStack = java.util.Stack<Char>()
        s.forEachIndexed { index, c ->
            if (index == 0 && !c.isLeft()) {
                return false
            }
            if (c.isLeft()) {
                leftStack.push(c)
            } else {
                if (leftStack.isNotEmpty()){
                    val result = leftStack.pop().isClosure(c)
                    if (!result) {
                        return false
                    }
                }else{
                    return false
                }

            }
        }
        return leftStack.isEmpty()
    }

    isValid("((()))").println()
    isValid("(((]))").println()
    isValid("[])))").println()
    isValid(")((()))").println()
}