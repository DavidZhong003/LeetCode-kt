package algorithm

/**
 * 冒泡排序算法
 * 时间复杂度 O(n²)
 * 空间复杂度 O(1)
 * 步骤:
 * 1. 比较相邻的两个元素,如果第一个大于第二个(或者小于),进行交换.
 * 2. 重复进行,最后一个元素是最大(最小)元素.
 * 3. 对所有未排序元素进行上述操作,知道排序完成.
 * @author  doive
 * on 2018/12/17 10:56
 */
class BubbleSort : IArraySort{
    override fun sort(array: IntArray): IntArray {
        for (index in array.indices){
            for (j in (0 until array.size-index-1)){
                if (array[j]>array[j+1]){
                    val temp = array[j]
                    array[j] = array[j+1]
                    array[j+1] = temp
                }
            }
        }
        return array
    }
}

fun main(args: Array<String>) {
    BubbleSort().sort(intArrayOf(1,4,3,5,56,7,89,69,88,12,4,6)).print()
    SelectionSort().sort(intArrayOf(3,4,5,2,3,7,8,9,10)).print()
}
