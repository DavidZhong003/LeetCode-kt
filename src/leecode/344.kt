package leecode

/**
 * 反转字符串
 * @author  doive
 * on 2019/6/24 15:28
 */
fun main() {
    fun reverseString(s: CharArray): Unit {
        if (s.size<=1){
            return
        }
        for (i in 0..s.lastIndex/2){
            val t = s[i]
            s[i] = s[s.lastIndex-i]
            s[s.lastIndex-i] = t
        }
        println(String(s))
    }

    reverseString("".toCharArray())
    reverseString("1234".toCharArray())
    reverseString("hello".toCharArray())

}
