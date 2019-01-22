package algorithm

/**
 * 希尔排序
 * 时间复杂度: O(n㏒n)
 * 空间复杂度: O(1)
 * 步骤:
 * 1.分组插入排序
 * @author  doive
 * on 2018/12/17 18:54
 */
class ShellSortSort:IArraySort{
    override fun sort(array: IntArray): IntArray {
        var gap = array.size/2
        while (gap>0){

            gap /=2
        }
        return array
    }
}