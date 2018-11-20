package leecode

/**
 *
 * @author  doive
 * on 2018/11/20 17:12
 */
val quest9 = """
    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
""".trimIndent()

fun isPalindrome(x: Int): Boolean {
    return when {
        x<0||(x%10==0&&x!=0) -> false
        else -> {
            //翻转一半
            var right = 0
            var left = x
            while (left > right) {
                right = left % 10 + 10 * right
                left /= 10
            }
            println("left = $left  right = $right")
            return right == left || left == right / 10
        }
    }
}

fun main(args: Array<String>) {
    isPalindrome(11).println()
}