package leecode

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * @author  doive
 * on 2019/5/29 17:47
 */
fun main() {
    fun permuteTemp(nums: IntArray, temp: MutableList<Int>,
                    result: MutableList<List<Int>>, visited: Array<Boolean>) {
        if (temp.size >= nums.size) {
            result.add(listOf(*temp.toTypedArray()))
            return
        }

        for (i in 0..nums.lastIndex) {
            if (visited[i]) {
                continue
            }
            visited[i] = true
            temp.add(nums[i])
            permuteTemp(nums, temp, result, visited)
            visited[i] = false
            temp.removeAt(temp.lastIndex)
        }
    }

    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        permuteTemp(nums, mutableListOf(), result, Array(nums.size) { false })
        return result
    }
    permute(intArrayOf()).println()
    permute(intArrayOf(1, 2, 3)).println()
    permute(intArrayOf(1, 2, 3, 4, 5)).println()

}
