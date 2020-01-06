package leecode

/**
 *
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author  doive
 * on 2020/1/6 19:52
 */
fun main() {
    uniquePathsWithObstacles(arrayOf(intArrayOf(0,0))).println()
    uniquePathsWithObstacles(arrayOf(intArrayOf(0), intArrayOf(0))).println()
    uniquePathsWithObstacles(arrayOf(intArrayOf(0,0))).println()
}

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    if(obstacleGrid.isEmpty()||obstacleGrid[0][0]==1){
        return 0
    }
    val row = obstacleGrid.size
    val column = obstacleGrid[0].size
    obstacleGrid[0][0] = 1
    for(i in 1 until column){
        obstacleGrid[0][i] = if(obstacleGrid[0][i]== 0 && obstacleGrid[0][i-1]==1) 1 else 0
    }

    for(j in 1 until row){
        obstacleGrid[j][0] = if(obstacleGrid[j][0] == 0 && obstacleGrid[j-1][0]==1)1 else 0
    }
    for(r in 1 until row){
        for(c in 1 until column){
            obstacleGrid [r][c]  = if(obstacleGrid[r][c] == 0) (obstacleGrid[r-1][c]+ obstacleGrid[r][c-1]) else 0
        }
    }
    return obstacleGrid[row-1][column-1]
}