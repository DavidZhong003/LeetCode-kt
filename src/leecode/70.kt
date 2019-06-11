package leecode

/**
 * 70. 爬楼梯
 * @author  doive
 * on 2019/6/11 09:45
 */
fun main() {
    fun climbStairs(n: Int): Int {
        if (n <= 2) {
            return n
        }
        val result = Array(n + 1) { 0 }
        result[0] = 0
        result[1] = 1
        result[2] = 2
        for (i in 3..n){
            result[i] = result[i-1]+result[i-2]
        }
        return result[n]
    }

    fun climbStairsRecursive(n: Int): Int {
        return if (n <= 2) {
            n
        } else {
            climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2)
        }
    }

    climbStairs(9).println()
    climbStairsRecursive(9).println()
}