package leecode

/**
 * 557. 反转字符串中的单词 III
 * @author  doive
 * on 2019/6/24 15:38
 */
fun main() {
    fun reverseWords(s: String): String {
       return s.split(' ').joinToString (separator = " ",transform = {
           it.reversed()
       })
    }

    reverseWords("Let's take LeetCode contest").println()
}