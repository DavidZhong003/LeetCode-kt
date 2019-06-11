package leecode

/**
 * 78. 子集
 * @author  doive
 * on 2019/6/11 10:07
 */
fun main() {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        result.add(emptyList())
        nums.forEach { n ->
            val temp = mutableListOf<List<Int>>()
            result.forEach {
                val t = mutableListOf<Int>()
                t.addAll(it)
                t.add(n)
                temp.add(t)
            }
            result.addAll(temp)
        }
        return result
    }

    subsets(intArrayOf()).forEach {
        it.println()
    }
    subsets(intArrayOf(1,2,3)).forEach {
        it.println()
    }
}