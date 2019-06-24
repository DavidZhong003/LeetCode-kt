package leecode

/**
 *
 * @author  doive
 * on 2019/6/24 14:30
 */

fun main() {
    fun lowestCommonAncestor(root:TreeNode?,p:TreeNode,q:TreeNode):TreeNode?{
        if (root==null||root==p||root==q){
            return root
        }
        val left = lowestCommonAncestor(root.left,p,q)
        val right = lowestCommonAncestor(root.right,p,q)
        return when{
            left!=null&&right!=null ->root
            left!=null -> left
            else->right
        }
    }
}