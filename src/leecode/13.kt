package leecode

/**
 * 罗马字符串转数字
 * @author  doive
 * on 2019/2/27 16:01
 */

fun main(args: Array<String>) {
    fun romanToInt(s: String): Int {

        val romanChars = mapOf('M' to 1000, 'D' to 500, 'C' to 100, 'L' to 50, 'X' to 10, 'V' to 5, 'I' to 1)

        var result = 0
        var ingor = false
        for (i in 0..s.lastIndex) {
            if (!romanChars.containsKey(s[i])) {
                throw IllegalArgumentException("make sure you input roman number")
            }
            if (ingor) {
                ingor = false
                continue
            }
            val current = s[i]
            val next = if (i != s.lastIndex) s[i + 1] else null
            val currentValue = romanChars.getValue(current)
            val nextValue = if (next != null) romanChars.getValue(next) else 0
            if (nextValue > currentValue) {
                result += (nextValue - currentValue)
                ingor = true
            } else {
                result += currentValue
            }
        }
        return result

    }

    romanToInt("MCMXCIV").println()
}
