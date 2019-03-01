package leecode

import java.util.*

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @author  doive
 * on 2019/3/1 10:18
 */
fun main(args: Array<String>) {
    fun letterCombinations(digits: String): List<String> {
        fun combination(chars: List<CharArray>, index: Int, list: MutableList<String>, temp: String = ""): MutableList<String> {
            var l = list
            if (index == chars.lastIndex) {
                // 最后
                chars.last().forEach {
                    l.add(temp+it)
                }
            } else {
                chars[index].forEachIndexed { j, c ->
                    l =  combination(chars, index+1, list, temp+c)
                }
            }
            return l

        }
        if (digits.isEmpty()) {
            return emptyList()
        }
        val chars = mutableListOf<CharArray>()
        digits.forEach {
            when (it) {
                '2' -> chars.add(charArrayOf('a', 'b', 'c'))
                '3' -> chars.add(charArrayOf('d', 'e', 'f'))
                '4' -> chars.add(charArrayOf('g', 'h', 'i'))
                '5' -> chars.add(charArrayOf('j', 'k', 'l'))
                '6' -> chars.add(charArrayOf('m', 'n', 'o'))
                '7' -> chars.add(charArrayOf('p', 'q', 'r', 's'))
                '8' -> chars.add(charArrayOf('t', 'u', 'v'))
                '9' -> chars.add(charArrayOf('w', 'x', 'y', 'z'))
            }
        }
        val result = LinkedList<String>()
        combination(chars,0,result,"")
        return result
    }



    letterCombinations("234").println()

}