package leecode

/**
 *
 * @author  doive
 * on 2018/11/15 21:41
 */
val quest7 = """
    给定一个 32 位有符号整数，将整数中的数字进行反转。
""".trimIndent()

fun reverse(x: Int): Int {
    var result = 0
    var original = x
    while (original != 0) {
        var pop = original % 10
        original /= 10
        //边界过滤
        if (result > Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && pop > 7)) return 0
        if (result < Int.MIN_VALUE / 10 || (result == Int.MIN_VALUE / 10 && pop < -8)) return 0
        result = result * 10 + pop
    }
    return result
}


fun main(args: Array<String>) {
    Int.MIN_VALUE.println()
    Int.MAX_VALUE.println()
}