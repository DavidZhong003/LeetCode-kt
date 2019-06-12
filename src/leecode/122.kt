package leecode

/**
 * 122. 买卖股票的最佳时机 II
 * @author  doive
 * on 2019/6/12 13:59
 */

fun main() {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size <= 1) {
            return 0
        }
        var result = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1]
            }
        }
        return result
    }

    maxProfit(intArrayOf(7,1,5,3,6,4)).println()
    maxProfit(intArrayOf(1,2,3,4,5)).println()
}
