package leecode

/**
 *
 * @author  doive
 * on 2018/11/14 16:11
 */
val quest6 = """
将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：

P   A   H   N
A P L S I I G
Y   I   R
之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"

实现一个将字符串进行指定行数变换的函数:
""".trimIndent()

fun convert(s: String, numRows: Int): String {
    //判断行数
    if (numRows <= 0) {
        throw IllegalArgumentException("num rows($numRows) should not less than or equal to 0")
    }
    if (numRows ==1){
        return s
    }
    val cacheRows = arrayListOf<StringBuffer>()
    for (it in 0 until Math.min(numRows, s.length)) {
        cacheRows.add(StringBuffer())
    }
    var currentRow = 0
    var isAddRow = false
    s.forEach { char ->
       cacheRows[currentRow].append(char)
       when(currentRow){
           0-> isAddRow = true
           numRows-1->isAddRow = false
       }
       currentRow += if (isAddRow) 1 else -1
    }
    return StringBuffer().apply {
        cacheRows.forEach { it -> this.append(it) }
    }.toString()
}

fun main(args: Array<String>) {
    convert("AB",1).println()
}