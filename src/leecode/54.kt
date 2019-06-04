package leecode

/**
 * 54. 螺旋矩阵
 * @author  doive
 * on 2019/6/4 14:08
 */
fun main() {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()
        if (matrix.isEmpty()){
            return result
        }
        val m = matrix.size
        val n = matrix[0].size
        var x1 = 0
        var x2 = n - 1
        var y1 = 0
        var y2 = m - 1
        while (result.size != m * n) {
            // 左->右
            for (i in x1..x2) {
                result.add(matrix[y1][i])
            }
            if (y1==y2) break
            y1++
            // 上->下
            for (i in y1..y2) {
                result.add(matrix[i][x2])
            }
            if (x1==x2) break
            // 右->左
            x2--
            for (i in x2 downTo x1) {
                result.add(matrix[y2][i])
            }
            if (y1==y2) break
            //下->上
            y2--
            for (i in y2 downTo y1){
                result.add(matrix[i][x1])
            }
            if (x1==x2)break
            x1++
        }
        return result
    }

    spiralOrder(arrayOf()).println()
    spiralOrder(arrayOf(intArrayOf(), intArrayOf(), intArrayOf())).println()
    spiralOrder(arrayOf(intArrayOf(1,2))).println()
    spiralOrder(arrayOf(intArrayOf(1,2,3,4), intArrayOf(5,6,7,8), intArrayOf(9,10,11,12))).println()
    spiralOrder(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9),intArrayOf(10,11,12))).println()
    spiralOrder(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))).println()
}