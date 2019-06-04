package leecode

/**
 * 53. 最大子序和
 * @author  doive
 * on 2019/6/3 21:15
 */

fun main() {
    /**
     * 动态规划
     * (-2, 1, -3, 4, -1, 2, 1, -5, 4)
     * max: -2 -2 1 1 4 4 5 6 6  6
     * ans: 0 -2 1 -2 4 3 5 6 -1 4
     */
    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var ans = 0
        var max = nums[0]
        for (i in 0..nums.lastIndex) {
            if (ans < 0) ans = 0
            ans += nums[i]
            max = Math.max(max, ans)
        }
        return max
    }

    /**
     * 分治算法
     */
    fun maxSubArraySuper(nums: IntArray): Int {
        fun maxSubArraySuper(nums: IntArray, left: Int, right: Int): Int {
            if (left == right) {
                return nums[left]
            }
            if (left == right - 1) {
                return Math.max(nums[left], Math.max(nums[right], nums[left] + nums[right]))
            }
            val mid = (left + right) / 2
            // 左边最大
            val leftMax = maxSubArraySuper(nums, left, mid - 1)
            // 右边最大
            val rightMax = maxSubArraySuper(nums, mid + 1, right)
            // 中间最大
            var max = nums[mid]
            var sum = max
            for (i in mid-1 downTo  left){
                sum += nums[i]
                max = Math.max(max,sum)
            }
            // 右边
            sum = max
            for (i in mid+1 .. right){
                sum += nums[i]
                max = Math.max(max,sum)
            }

            return Math.max(leftMax,Math.max(rightMax,max))
        }
        return maxSubArraySuper(nums, 0, nums.lastIndex)
    }
    var startTime = System.currentTimeMillis()
    maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4,1)).println()
    "消耗时间:${(System.currentTimeMillis()-startTime)}ms".println()
    startTime = System.currentTimeMillis()
    maxSubArraySuper(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4,1)).println()
    "消耗时间:${(System.currentTimeMillis()-startTime)}ms".println()
}
