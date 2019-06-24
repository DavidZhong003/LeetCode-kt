package leecode

/**
 * 存在重复元素
 * @author  doive
 * on 2019/6/21 16:01
 */
fun main() {
    fun containsDuplicate(nums: IntArray): Boolean {
        if (nums.size<=1){
            return false
        }
        val set = mutableSetOf<Int>()
        nums.forEach {
            if (!set.add(it)){
                return true
            }
        }
        return set.size!=nums.size
    }
    containsDuplicate(intArrayOf(1,2,3,4)).println()
    containsDuplicate(intArrayOf(1,1)).println()
}