package leecode

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * [-3,-3,-1,0,0,1,2,3]  0
 * [-3,-3,-1,0,0,1,2,3]
0
 * @author  doive
 * on 2019/3/1 11:47
 */
fun main(args: Array<String>) {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        if (nums.size < 4) {
            return emptyList()
        }
        nums.sort()
        val result = mutableListOf<List<Int>>()
        for (i in 0 until nums.lastIndex - 2) {
            if (i>0&&nums[i]==nums[i-1]){
                continue
            }
            // 3数之和
            val sum3 = target - nums[i]
            for (j in (i + 1) until nums.lastIndex-1) {
                if (j>i+1&&nums[j]==nums[j-1]){
                    continue
                }
                // 两数之和
                val sum2 = sum3 - nums[j]
                var s = j + 1
                var e = nums.lastIndex
                while (s < e) {
                    when {
                        nums[s] + nums[e] > sum2 -> {
                            // 防止重复
                            while (s < e && nums[e] == nums[e - 1]) e--
                            e--

                        }
                        nums[s] + nums[e] < sum2 -> {
                            while (s < e && nums[s] == nums[s + 1]) s++
                            s++
                        }
                        else -> {
                            result.add(listOf(nums[i], nums[j], nums[s], nums[e]))
                            while (s < e && nums[e] == nums[e - 1]) e--
                            while (s < e && nums[s] == nums[s + 1])  s++
                            e--
                            s++
                        }
                    }
                }

            }
        }
        return result
    }

    fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0).println()
}