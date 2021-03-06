package leecode

/**
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * @author  doive
 * on 2019/5/16 11:20
 */

fun main() {
    fun search(nums: IntArray, target: Int): Int {
        fun search(nums: IntArray, low: Int, high: Int, target: Int): Int {
            if (nums.isEmpty()) {
                return -1
            }
            if (low > high) {
                return -1
            }
            val mid = (low + high) / 2
            when {
                nums[mid] == target -> return mid
                nums[mid] < nums[high] -> {
                    return if (target > nums[mid] && target <= nums[high]) {
                        search(nums, mid + 1, high, target)
                    } else {
                        search(nums, low, mid - 1, target)
                    }
                }
                else -> {
                    //无序
                    return if (target < nums[mid] && target >= nums[low]) {
                        search(nums, low, mid - 1, target)
                    } else {
                        search(nums, mid + 1, high, target)
                    }
                }
            }
        }
        if (nums.isEmpty()) {
            return -1
        }


        return search(nums, 0, nums.lastIndex, target)
    }

    search(arrayOf(1,2,3).toIntArray(),3).println()

}
