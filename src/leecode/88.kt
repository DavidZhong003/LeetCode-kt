package leecode

import algorithm.print

/**
 * 88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * @author  doive
 * on 2019/6/11 10:51
 */
fun main() {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        if (n <= 0) {
            return
        }
        var tempM = m - 1
        var tempN = n - 1
        //  合并后的长度m+n-1
        var p = m + n - 1
        while (tempM >= 0 && tempN >= 0) {
            nums1[p--] = if (nums1[tempM] > nums2[tempN]) nums1[tempM--] else nums2[tempN--]
        }
        //数组2未排完
        while (tempN >= 0) {
            nums1[p--] = nums2[tempN--]
        }
        nums1.print()
    }

    merge(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(4, 5, 6), 3)
}