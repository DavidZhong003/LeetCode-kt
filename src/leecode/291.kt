package leecode

/**
 * 292. Nim 游戏
 * 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 * @author  doive
 * on 2019/6/24 15:13
 */
fun main() {
    /**
     * 0,4 输
     * 5,6,7赢
     * 8,输
     * 9,10,11 赢
     */
    fun canWinNim(n: Int): Boolean {
        return n%4!=0
    }
}
