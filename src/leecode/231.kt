package leecode

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * @author  doive
 * on 2019/6/24 10:59
 */
fun main() {
    fun isPowerOfTwo(n: Int): Boolean {
//        return n>0 && (n and -n)==n
        return n>0 && n.and(n-1)==0
    }
    isPowerOfTwo(1).println()
    isPowerOfTwo(2).println()
    isPowerOfTwo(3).println()
}