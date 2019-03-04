package leecode

/**
 * 括号生成
 * @author  doive
 * on 2019/3/4 17:07
 */
fun main(args: Array<String>) {
    fun generateParenthesis(n: Int): List<String> {
        if (n<=0){
            return emptyList()
        }
        /**
         * [leftCount] 左括号数量
         * [rightCount] 右括号数量
         *
         */
        fun build(result:MutableList<String>, leftCount:Int, rightCount:Int, temp:String){
           if (leftCount==0&&rightCount==0){
               result.add(temp)
           }
           if (leftCount>0){
               build(result, leftCount-1, rightCount, "$temp(")
           }
           if (leftCount<rightCount){
               build(result, leftCount, rightCount-1, "$temp)")
           }
        }
        val result = mutableListOf<String>()
        build(result,n,n,"")
        return result
    }


//    generateParenthesis(1).println()
//    generateParenthesis(2).println()
    generateParenthesis(3).println()
//    generateParenthesis(4).println()
}