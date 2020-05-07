package leecode

/**
 * 二叉树的序列化与反序列化
 * @author  doive
 * on 2020/5/7 10:28
 */


class Codec {

    // Encodes a tree to a single string.
    fun serialize(root: TreeNode): String {
        val res = serialize(root, StringBuffer())
        return res.toString()
    }

    private fun serialize(root: TreeNode?, stringBuffer: StringBuffer): StringBuffer {
        var str = stringBuffer
        if (null == root) {
            str.append("null,")
            return str
        }
        str.append(root.`val`)
        str.append(",")
        str = serialize(root.left, str)
        str = serialize(root.right, str)
        return str
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        return deserialize(data.split(",").toMutableList())
    }

    private fun deserialize(mutableList: MutableList<String>):TreeNode?{
        if (mutableList.isEmpty()){
            return null
        }
        if (mutableList.first() == "null"){
            mutableList.removeAt(0)
            return null
        }
        val node = TreeNode(mutableList.first().toInt())
        mutableList.removeAt(0)
        node.left = deserialize(mutableList)
        node.right = deserialize(mutableList)
        return node
    }
}

fun main() {
    val codec = Codec()
    val nodeString =codec.serialize(TreeUtils.createTree(1,2,3,null,null,4,5)!!)
    println(nodeString)
    println(codec.deserialize(nodeString))
}