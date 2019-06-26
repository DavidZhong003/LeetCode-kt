package algorithm

import leecode.println
import java.util.Arrays

/**
 *
 * @author  doive
 * on 2018/12/17 11:06
 */
internal interface IArraySort {
    fun sort(array: IntArray): IntArray

    /**
     * 交换两个数值
     */
     fun IntArray.swap( p: Int, q: Int) {
        this[p] = this[p] xor this[q]
        this[q] = this[p] xor this[q]
        this[p] = this[p] xor this[q]
    }
}

fun IntArray.print() = Arrays.toString(this).println()