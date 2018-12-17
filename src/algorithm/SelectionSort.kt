package algorithm

/**
 * 选择排序
 * 时间复杂度 O(n²)
 * 空间复杂度 O(1)
 * 步骤:
 * 1. 选择出最大(最小)元素放到最后(起始)位置.
 * 2. 对剩下未排序元素进行同样处理,直到所有元素排序完成
 * @author  doive
 * on 2018/12/17 14:11
 */
class SelectionSort : IArraySort {
    override fun sort(array: IntArray): IntArray {
        for (i in array.indices) {
            var min = i
            for (j in (i + 1 until array.size)) {
                if (array[j] < array[min]) {
                    min = j
                }
            }
            if (min != i) {
                val temp = array[i]
                array[i] = array[min]
                array[min] = temp
            }

        }
        return array
    }
}