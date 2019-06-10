package leecode

import java.util.Arrays

/**
 * 59. 螺旋矩阵 II
 * @author  doive
 * on 2019/6/5 15:00
 */
fun main() {
    fun generateMatrix(n: Int): Array<IntArray> {
        val result = Array(n) { IntArray(n) }
        var current = 1
        var m = 0
        while (current <= n * n) {
            //左->右
            for (i in m until (n - m)) {
                result[m][i] = current++
            }
            //上->下
            for (i in m + 1 until n - m) {
                result[i][n - m - 1] = current++
            }
            //右->左
            for (i in (n - m - 2) downTo m ) {
                result[n - m - 1][i] = current++
            }

            for (i in (n - m - 2) downTo m + 1) {
                result[i][m] = current++
            }
            m++
        }
        return result
    }

    generateMatrix(0).forEach {
        Arrays.toString(it).println()
    }
    generateMatrix(1).forEach {
        Arrays.toString(it).println()
    }
    generateMatrix(2).forEach {
        Arrays.toString(it).println()
    }
    generateMatrix(3).forEach {
        Arrays.toString(it).println()
    }
    generateMatrix(4).forEach {
        Arrays.toString(it).println()
    }
}

