package leecode

/**
 * 62. 不同路径
 * @author  doive
 * on 2019/6/10 17:13
 */
fun main() {
    fun uniquePaths(m: Int, n: Int): Int {
        if (m <= 0 || n <= 0) {
            return 0
        }
        val temp = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i == 0 || j == 0) {
                    temp[i][j] = 1
                } else {
                    temp[i][j] = temp[i - 1][j] + temp[i][j - 1]
                }
            }
        }
        return temp[m - 1][n - 1]
    }

    fun uniquePathsRecursive(m: Int, n: Int): Int {
        if (m <= 0 || n <= 0) {
            return 0
        }
        if (m == 1 || n == 1) {
            return 1
        }
        return uniquePathsRecursive(m - 1, n) + uniquePaths(m, n - 1)
    }

    uniquePaths(3,2).println()

}