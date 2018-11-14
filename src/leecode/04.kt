package leecode

/**
 *
 * @author  doive
 * on 2018/11/11 17:17
 */
val quest4 = """

给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。

请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。

你可以假设 nums1 和 nums2 不同时为空。

""".trimIndent()

/**
 * 获取一个数组中[start,end]的中位数
 */

fun IntArray.findMid(start: Int = 0, end: Int = lastIndex): Double {
    if (this.isEmpty()) {
        return 0.0
    }
    if (start < 0 || end > lastIndex || start > end) {
        throw IndexOutOfBoundsException()
    }
    val length = end - start + 1
    return if (length % 2 == 1) {
        this[start + length / 2].toDouble()
    } else {
        (this[start + length / 2] + this[end - length / 2]) / 2.0
    }
}

fun Any?.println() = println(this.toString())
/**
 *
 */
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val size1 = nums1.size
    val size2 = nums2.size
    if (size1 > size2) {
       return findMedianSortedArrays(nums2, nums1)
    }
    if (nums1.isEmpty()) {
        return (nums2[(nums2.size-1)/2]+nums2[nums2.size/2])/2.0
    }
    //后缀映射
    var low = 0
    var high = size1 * 2
    while (low <= high) {
        val c1 = low + (high - low) / 2
        val c2 = size2 + size1 - c1
        val l1 = if (c1 == 0) Int.MIN_VALUE else nums1[(c1 - 1) / 2]
        val r1 = if (c1 == 2 * size1) Int.MAX_VALUE else nums1[(c1) / 2]
        val l2 = if (c2 == 0) Int.MIN_VALUE else nums2[(c2 - 1) / 2]
        val r2 = if (c2 == 2 * size2) Int.MAX_VALUE else nums2[c2 / 2]
        when {
            l1 > r2 -> high = c1 - 1
            l2 > r1 -> low = c1 + 1
            else -> return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0
        }
    }
    return 0.0
}


fun main(args: Array<String>) {
    quest4.println()
    findMedianSortedArrays(intArrayOf( 2, 3), intArrayOf(1)).println()
}