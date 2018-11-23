package leecode

/**
 *
 * @author  doive
 * on 2018/11/23 17:02
 */

val quest11 = """
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。
""".trimIndent()


fun maxArea(height: IntArray): Int {
    if (height.size < 2) {
        return 0
    }
    var result = 0
    var low = 0
    var high = height.lastIndex
    while (low < high) {
        val temp = (high - low) * Math.min(height[low], height[high])
        if (temp > result) {
            result = temp
        }
        if (height[low]<height[high]){
            low++
        }else{
            high--
        }
    }
    return result
}

fun main(args: Array<String>) {
    maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)).println()
}