package leecode

/**
 *给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * @author  doive
 * on 2019/2/28 15:10
 */
fun main(args: Array<String>) {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) {
            return emptyList()
        }
        nums.sort()
        val result = ArrayList<List<Int>>()
        for (i in 0 until nums.lastIndex) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                var s = i + 1
                var e = nums.lastIndex
                val sum = 0 - nums[i]

                while (s < e) {
                    when {
                        nums[s] + nums[e] == sum -> {
                            result.add(listOf(nums[i], nums[s], nums[e]))
                            while (s<e&&nums[s]==nums[s+1]) s++
                            while (s<e&&nums[e]==nums[e-1])e--
                            s++
                            e--
                        }
                        nums[s] + nums[e] > sum -> {
                            while (s<e&&nums[e]==nums[e-1])e--
                            e--
                        }
                        else -> {
                            while (s<e&&nums[s]==nums[s+1]) s++
                            s++
                        }
                    }
                }
            }
        }
        return result

    }

    threeSum(intArrayOf(1,-1,0,2,-1,-4)).println()
}