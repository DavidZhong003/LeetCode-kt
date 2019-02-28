package leecode

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * @author  doive
 * on 2019/2/28 16:24
 */
fun main(args: Array<String>) {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        if (nums.size<3){
            throw IllegalArgumentException("check nums size >=3")
        }
        nums.sort()
        var result = nums[0]+nums[1]+nums[2]
        for (i in 0 until nums.lastIndex){
            var s = i+1
            var e = nums.lastIndex
            while (s<e){
                val close = nums[i] +nums[s] +nums[e]
                if (Math.abs(result-target)>Math.abs(close-target)){
                    result = close
                }
                when{
                    target<close -> e--
                    target == close -> return close
                    else -> s++
                }
            }
        }
        return result
    }
    //[-3,-2,-5,3,-4]
    //-1
    threeSumClosest(intArrayOf(-3,-2,-5,3,-4),-1).println()
}
