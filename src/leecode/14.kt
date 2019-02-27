package leecode

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""
 * @author  doive
 * on 2019/2/27 16:57
 */

fun main(args: Array<String>) {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }
        if (strs.size == 1) {
            return strs[0]
        }
        val sb = StringBuffer("")
        var index = 0
        try {
            while (true) {
                val temp  = strs[0].get(index)
                strs.forEach {
                    val char = it.get(index)
                    if (char!=temp){
                        return sb.toString()
                    }
                }
                sb.append(temp)
                index++
            }
        }catch (e:IndexOutOfBoundsException){
            return sb.toString()
        }

    }

    longestCommonPrefix(arrayOf("dog")).println()
    longestCommonPrefix(arrayOf("dog","dooooo")).println()
    longestCommonPrefix(arrayOf("dog","")).println()
    longestCommonPrefix(arrayOf("flower","flow","flight")).println()
}
