package leecode

/**
 * 121. 买卖股票的最佳时机
 * @author  doive
 * on 2019/6/12 11:36
 */
fun main() {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()){
            return 0
        }
        var result =0
        var min =prices[0]
        prices.forEach {
            if (it<min){
                min = it
            }
            if ((it-min)>result){
                result = it-min
            }
        }
        return result
    }

    maxProfit(intArrayOf(7,1,6,4,3,2)).println()
}