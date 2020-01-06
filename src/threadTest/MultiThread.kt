package threadTest

import java.lang.management.ManagementFactory

/**

 * @author  doive
 * on 2019/7/5 15:38
 */

fun main() {
    printThreadInfo()

}

/**
 * 线程信息打印
 * 打印一个java 程序里面的线程情况
 * 1. main 主线程 state : running
 * 2. Reference Handler Reference清除线程 state waiting
 * 3. Finalizer 垃圾回收线程 state waiting
 * 4. signal dispatcher 分发JVM信号线程
 */
private fun printThreadInfo() {
    val mxBean = ManagementFactory.getThreadMXBean()
    println(mxBean)
    mxBean.dumpAllThreads(false, false).forEach {
        println("thread Id = ${it.threadId}, thread name = ${it.threadName} , thread state = ${it.threadState}")
    }
}


fun threadState(){
    Thread(Runnable{
        while (true){
            Thread.sleep(100*1000)
        }
    },"TimeWaitingThreadState").start()
}