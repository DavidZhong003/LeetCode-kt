package algorithm

/**
 * 堆排序
 * @author  doive
 * on 2019/6/25 20:20
 */

class HeapSort :IArraySort{
    override fun sort(array: IntArray): IntArray {
        if (array.size <= 1) {
            return array
        }
        //构建最大堆
        buildMaxHeap(array, array.size)
        for (i in array.lastIndex downTo 1) {
            array.swap( i, 0)
            buildMaxHeap(array, i)
        }
        return array
    }

    private fun buildMaxHeap(array: IntArray, size: Int) {
        val lastP = (size - 2) / 2
        for (i in lastP downTo 0) {
            heapifyMax(array, size, i)
        }
    }

    private fun heapifyMax(array: IntArray, size: Int, i: Int) {
        if (i >= size) {
            return
        }
        val leftC = i * 2 + 1
        val rightC = i * 2 + 2
        var max  = i
        if (leftC<size&&array[leftC]>array[max]){
            max = leftC
        }
        if (rightC<size&&array[rightC]>array[max]){
            max = rightC
        }
        if (max!=i){
            array.swap(max,i)
            heapifyMax(array, size, max)
        }
    }



}
fun main() {
    val array = intArrayOf(5, 35, 7, 2, 88, 22, 9, 8, 0)
    HeapSort().sort(array)
    array.print()
}

