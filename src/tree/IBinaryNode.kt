package tree

/**
 * 二叉树节点
 * @author doive
 * on 2019/1/24 17:23
 */
interface IBinaryNode<V>{
    /**
     * 获取存储值
     */
    fun getValue():V

    /**
     * 获取左节点
     */
    fun getLeftNode() : IBinaryNode<V>?

    /**
     * 获取右节点
     */
    fun  getRigthNode() : IBinaryNode<V>?

    /**
     * 获取父节点
     */
    fun  getParentsNode():IBinaryNode<V>?
}
