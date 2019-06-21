package leecode

import algorithm.print

/**
 *
 * @author  doive
 * on 2019/6/20 17:17
 */
fun main() {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        fun sortKth(nums: IntArray, left: Int, right: Int, position: Int) {
            if (left > right) {
                return
            }
            val temp = nums[left]
            var l = left
            var r = right
            while (l < r) {
                while (l < r && nums[r] <= temp) {
                    r--
                }
                while (l < r && nums[l] >= temp) {
                    l++
                }
                if (l < r) {
                    val t = nums[l]
                    nums[l] = nums[r]
                    nums[r] = t
                }
            }
            nums[left] = nums[l]
            nums[l] = temp
            when {
                l > position -> {
                    sortKth(nums, left, l - 1, position)
                }
                l < position -> {
                    sortKth(nums, l + 1, right, position)
                }
                else -> return
            }
        }
        sortKth(nums, 0, nums.lastIndex, k-1)
        nums.print()
        return nums[k-1]
    }

    /**
     * 桶排序
     */
    fun bucketSort(nums: IntArray): IntArray {
        if (nums.size <= 1) {
            return nums
        }
        var min = nums[0]
        var max = nums[0]
        nums.forEach {
            min = Math.min(min, it)
            max = Math.max(max, it)
        }
        //桶
        val buckets = IntArray(max - min + 1)
        nums.forEach {
            buckets[it - min]++
        }
        buckets.print()
        var i = 0
        buckets.forEachIndexed { index, value ->
            if (value != 0) {
                var j = value
                while (j > 0) {
                    nums[i++] = index + min
                    j--
                }
            }
        }

        return nums
    }

    /**
     * 快排序
     */
    fun quickSort(nums: IntArray): IntArray {
        fun quickSort(nums: IntArray, low: Int, high: Int) {
            if (low > high) {
                return
            }
            var l = low
            var r = high
            // 基准值
            val temp = nums[l]
            while (l < r) {
                while (l < r && nums[r] >= temp) {
                    r--
                }
                while (l < r && nums[l] <= temp) {
                    l++
                }
                //交换数据
                if (l < r) {
                    val t = nums[l]
                    nums[l] = nums[r]
                    nums[r] = t
                }
            }
            //交换基准值
            nums[low] = nums[l]
            nums[l] = temp
            quickSort(nums, low, l - 1)
            quickSort(nums, l + 1, high)
        }
        quickSort(nums, 0, nums.lastIndex)
        return nums
    }

//    bucketSort(intArrayOf(4, 2, 5, 1, 7, 3, 2, 7, 10)).print()
    findKthLargest(intArrayOf(5, 2, 4, 1, 3, 6, 0), 4).println()
    findKthLargest(intArrayOf(3,2,1,5,6,4),2).println()
    findKthLargest(intArrayOf(3,2,3,1,2,4,5,5,6),4).println()

}