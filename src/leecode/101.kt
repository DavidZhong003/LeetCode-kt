package leecode




/**
 * 对称二叉树
 * @author  doive
 * on 2020/4/29 17:58
 */

fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }

    return isSymmetric(root.left,root.right)
}

private fun isSymmetric(left:TreeNode?,right: TreeNode?):Boolean{
    if (left==null&&right==null){
        return true
    }
    if (left==null||right==null||left.`val`!=right.`val`){
        return false
    }
    return isSymmetric(left.left,right.right)&& isSymmetric(left.right, right.left)
}
