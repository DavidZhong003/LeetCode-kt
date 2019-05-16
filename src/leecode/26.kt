package leecode

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，
 * 使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，
 * 你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @author  doive
 * on 2019/5/15 16:42
 */
fun main() {
    fun removeDuplicates(nums: IntArray): Int {
        var i = 0
        for (n in nums){
            if (i < 1 || n > nums[i - 1]){
                nums[i++] = n
            }
        }
        return i
    }

    removeDuplicates(intArrayOf(0, 0, 1, 1, 2, 2, 3, 3, 4, 4)).println()
}