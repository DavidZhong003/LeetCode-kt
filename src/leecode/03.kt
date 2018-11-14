package leecode

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * @author  doive
 * on 2018/11/10 15:29
 */
fun lengthOfLongestSubstring(s: String): Int {
    if (s.length==1) return 1
    val cache = mutableMapOf<Char,Int>()
    var result = 0
    var start = 0
    //[start,index]窗口
    s.forEachIndexed { index, c ->
        if (cache.containsKey(c)){
            //调整窗口
            start=Math.max(start, cache[c]!!)
        }
        //比较窗口和结果大小
        result = Math.max(result,index-start+1)
        cache[c] = index+1
    }

    return result
}

fun main(args: Array<String>) {
    println(lengthOfLongestSubstring("au"))
}