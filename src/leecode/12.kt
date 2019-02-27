package leecode

/**
 * 整数转罗马
 * @author  doive
 * on 2018/11/23 18:30
 */

fun intToRoman(num: Int): String {
    // 确保输入是1-3999之间
    if (num < 1 || num > 3999) {
        throw IllegalArgumentException("check input num value")
    }
    val romanMap = mapOf(
            1000 to "M",
            900 to "CM",
            500 to "D",
            400 to "CD",
            100 to "C",
            90 to "XC",
            50 to "L",
            40 to "XL",
            10 to "X",
            9 to "IX",
            5 to "V",
            4 to "IV",
            1 to "I")

    val sb = StringBuilder()
    var temp = num
    romanMap.forEach { t, u ->
        while (temp>=t){
            sb.append(u)
            temp -=t
        }
    }
    return sb.toString()

}

fun main(args: Array<String>) {
    intToRoman(4).println()
    intToRoman(8).println()
    intToRoman(9).println()
    intToRoman(10).println()
    intToRoman(44).println()
    intToRoman(58).println()
}