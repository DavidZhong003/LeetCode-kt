package leecode

/**
 * @author  doive
 * on 2018/11/5 13:49
 */
private val quest1 = """
给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

""".trimIndent()

/**
 * 遍历传入数组，存下对应的值以及索引，遍历时候判断是否含有 目标值-value 值
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    mutableMapOf<Int,Int>().apply {
        nums.forEachIndexed { index, i ->
            if (this.containsKey(target-i)){
                return intArrayOf(this[target-i]!!,index)
            }
            this[i] = index
        }
    }
    throw IllegalArgumentException("not found")
}

fun main(args: Array<String>) {
    println(quest1)
    twoSum(intArrayOf(2,7,11,15),9).apply {
        print(this.contentToString())
    }
}