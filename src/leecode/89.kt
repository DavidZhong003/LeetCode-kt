package leecode



/**
 * 格雷编码
 * @author  doive
 * on 2019/6/11 15:15
 */


fun main() {
    fun grayCode(n: Int): List<Int> {
        val result = mutableListOf<Int>()
        for (i in 0 until (1 shl n)) result.add(i xor (i shr 1))
        return result
    }
    grayCode(0).println()
    grayCode(1).println()
    grayCode(2).println()
    grayCode(3).println()
}