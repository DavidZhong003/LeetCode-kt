package algorithm

/**
 * 插入排序
 * 时间复杂度: O(n²)
 * 空间复杂度: 0(1)
 * 步骤:
 * 1. 第一个元素开始当做有序数组,后面为无序
 * 2. 无序中取出第一个元素,插入有序中
 * @author  doive
 * on 2018/12/17 16:20
 */
class InsertSort : IArraySort {
    override fun sort(array: IntArray): IntArray {
        if (array.isEmpty()) {
            return array
        }
        for (i in (1 until array.size)) {
            val temp = array[i]
            var j = i
            while (j > 0 && (temp < array[j - 1])) {
                array[j] = array[j - 1]
                j--
            }
            if (j != i) {
                array[j] = temp
            }
        }
        return array
    }

}