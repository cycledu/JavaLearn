package DataStructures.huffmantree;

import java.util.*;

/**
 * @Author : jingtao
 * @Data : 2020/10/31/9:26
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */
public class protice {

    static Map<String, Integer> map = new HashMap<>();
    static int WPL = 0;
    static StringBuilder sb = new StringBuilder();
    static Map<String, String> result = new HashMap();

    public static void main(String[] args) {
        String string = "i like like like java do you like a java";
        String[] split = string.split("");
        //统计每个字符的出现次数
        executeSplit(split);
        List<Node2> nodes = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            nodes.add(new Node2(entry.getValue(), entry.getKey()));
        }
        System.out.println(nodes);
        Node2 root = createTree(nodes);
        infixOrder(root);
        // 计算WPL
        caculateWPL(root, "");
        //所有叶子结点的对应编码为{ =11, a=1100, d=11000, u=01, e=110, v=01, i=01, y=110, j=010, k=01, l=000, o=01}
        System.out.println("所有叶子结点的对应编码为" + result);
    }


    private static void caculateWPL(Node2 node, String s) {
        sb.append(s);
        if (node != null) {
            if (node.content == null) {// 非叶子结点
                // 向左递归
                caculateWPL(node.left, "0");// 向左递归拼接0
                caculateWPL(node.right, "1");// 向右递归拼接1
            } else {
                // 说明为叶子结点停止循环
                result.put(node.content, sb.toString());
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private static Node2 createTree(List<Node2> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node2 node1 = nodes.get(0);
            Node2 node2 = nodes.get(1);
            Node2 newNode = new Node2(node1.weight + node2.weight, null);
            newNode.left = node1;
            newNode.right = node2;
            nodes.remove(node1);
            nodes.remove(node2);
            nodes.add(newNode);
        }
        return nodes.get(0);
    }

    private static void executeSplit(String[] split) {
        for (String s : split) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else
                map.put(s, 1);
        }
    }

    private static void infixOrder(Node2 node2) {
        if (node2.content != null)
            System.out.println("中序：" + node2);
        if (node2.left != null)
            infixOrder(node2.left);
        if (node2.right != null)
            infixOrder(node2.right);
    }
}
