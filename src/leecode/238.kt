package leecode

import algorithm.print

/**
 *
 * @author  doive
 * on 2019/6/24 14:47
 */
fun main() {
    fun productExceptSelf(nums: IntArray): IntArray {
        if (nums.size <= 1) {
            return nums
        }
        val result = IntArray(nums.size)
        var temp = 1
        nums.forEachIndexed { index, i ->
            result[index] = temp
            temp *= i
        }
        temp = 1
        for (i in nums.lastIndex downTo 0) {
            result[i] *= temp
            temp *= nums[i]
        }
        return result
    }

    productExceptSelf(intArrayOf(1, 2, 3, 4)).print()
}