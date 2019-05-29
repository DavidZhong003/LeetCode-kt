package leecode

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * @author  doive
 * on 2019/5/28 18:29
 */
fun main() {
    fun multiply(num1: String, num2: String): String {
        val resultArray = IntArray(num1.length + num2.length)
        for (i in num1.lastIndex downTo 0) {
            for (j in num2.lastIndex downTo 0) {
                resultArray[i + j + 1] += (num1[i] - '0') * (num2[j] - '0')
            }
        }
        var needAdd = 0
        for (i in resultArray.lastIndex downTo 0) {
            val temp = resultArray[i] +needAdd
            resultArray[i] = temp  % 10
            needAdd = temp / 10
        }
        var offset = 0
        while (offset < resultArray.lastIndex && resultArray[offset] == 0) {
            offset++
        }
        for (i in offset..resultArray.lastIndex) {
            resultArray[i] = resultArray[i] + '0'.toInt()
        }
        return String(resultArray, offset, resultArray.size - offset)
    }
    multiply("123", "456").println()
    multiply("1234567890", "1234567890").println()
    multiply("12345678998", "0").println()

}

