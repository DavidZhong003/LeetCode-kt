package algorithm

import leecode.println
import java.util.*

/**
 *
 * @author  doive
 * on 2018/12/17 11:06
 */
internal interface IArraySort {
    fun sort(array: IntArray): IntArray
}

fun IntArray.print() = Arrays.toString(this).println()