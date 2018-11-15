package leecode

/**
 *
 * @author  doive
 * on 2018/11/14 11:29
 */
val question5 = """

给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。

""".trimIndent()


fun longestPalindrome(s: String): String {
    fun String.findLongest(left:Int,right:Int):String{
        var l = left
        var r = right
        while (l>=0&&r<=lastIndex&& this[l] ==this[r]){
            l--
            r++
        }
        return s.substring(l+1,r)
    }
    if (s.length<=1) return s

    //存储最长子串
    var result = ""
    s.forEachIndexed { index, _ ->
        //自己为中心
        val temp1 = s.findLongest(index,index)
        if (temp1.length>result.length){
            result = temp1
        }
        //间隔为中心
        val temp2 = s.findLongest(index,index+1)
        if (temp2.length>result.length){
            result = temp2
        }
        println("$temp1   $temp2    $result")
    }
    return result
}

fun main(args: Array<String>) {
    longestPalindrome("ac").println()
}

