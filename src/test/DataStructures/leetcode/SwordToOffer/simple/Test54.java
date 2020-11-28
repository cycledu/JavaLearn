package DataStructures.leetcode.SwordToOffer.simple;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/06/24/22:20
 * @Description :给定一棵二叉搜索树，请找出其中第k大的节点。
 * @Page or WebSite：
 * @Expected result ：
 */
//题意为找到二叉树中序遍历的倒数第k个节点，则可将二叉树中序遍历后返回相应节点值，或进行中序的倒序遍历，k值自减为0时，此时就是结果值
public class Test54 {
    static List<TreeNode> treeNodes = new LinkedList<>();
    public int kthLargest(TreeNode root, int k) {
        infixOrder(root);
        return treeNodes.get(treeNodes.size()-k).val;
    }
    private void infixOrder(TreeNode root) {
        if (root.left!=null){
            infixOrder(root.left);
        }
        treeNodes.add(root);
        if (root.right!=null){
            infixOrder(root.right);
        }
    }
/**
 *     int count=0, res=0;//形参k不能随着dfs的迭代而不断变化，为了记录迭代进程和结果，引入类变量count和res。
 *     public int kthLargest(TreeNode root, int k) {
 *         this.count=k;//利用形参值k对类变量count进行初始化
 *         dfs(root);//这里不要引入形参k，dfs中直接使用的是初始值为k的类变量count
 *         return res;
 *     }
 *     public void dfs(TreeNode root){
 *         if(root==null||count==0) return;//当root为空或者已经找到了res时，直接返回
 *         dfs(root.right);
 *         if(--count==0){//先--，再判断
 *             res = root.val;
 *             return;//这里的return可以避免之后的无效迭代dfs(root.left);
 *         }
 *         dfs(root.left);
 *     }
 */
}
