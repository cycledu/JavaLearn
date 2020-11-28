package DataStructures.huffmantree;

import java.util.*;

public class HuffmanCode {

    public static void main(String[] args) {
        String string = "i like like like java do you like a java";
        byte[] contenrBytes = string.getBytes();// 40位长度的字符byte数组

        /**
         * 分步骤 // 统计字符本身的值和字符出现的次数(权值)生成对象放入集合 List<Node2> node2list =
         * getNode(contenrBytes); System.out.println(node2list); // 根据集合创建赫夫曼树
         * Node2 huffman = createHuffman(node2list); System.out.println("头结点：" +
         * huffman); // getCodes(huffman, "", stringBuilder); //
         * 根据赫夫曼树生成每一个叶子结点的字符值对应的赫夫曼编码 Map<Byte, String> codes =
         * getCodes(huffman); System.out.println("处理后的赫夫曼编码对应表:" + codes);
         * System.out.println(Arrays.toString(zip(contenrBytes, huffmancodes)));
         */

        byte[] huffmanZip = huffmanZip(contenrBytes);
        System.out.println(Arrays.toString(huffmanZip));

        List<Node2> node2list = getNode(contenrBytes);
        Node2 huffman = createHuffman(node2list);
        Map<Byte, String> codes = getCodes(huffman);
        byte[] decode = decode(codes, huffmanZip);
        System.out.println("原来的字符串=" + new String(decode));


    }

    // 编写一个方法，完成对压缩数据的解码

    /**
     * @param huffmanCodes 赫夫曼编码表 map
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 就是原来的字符串对应的数组
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        // 1. 先得到 huffmanBytes 对应的 二进制的字符串 ， 形式 1010100010111...
        StringBuilder stringBuilder = new StringBuilder();
        // 将byte数组转成二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            // 判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        // 把字符串按照指定的赫夫曼编码进行解码
        // 把赫夫曼编码表进行调换，因为反向查询 a->100 100->a
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        // 创建要给集合，存放byte
        List<Byte> list = new ArrayList<>();
        // i 可以理解成就是索引,扫描 stringBuilder
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        // 当for循环结束后，我们list中就存放了所有的字符 "i like like like java do you like a java"
        // 把list 中的数据放入到byte[] 并返回
        byte b[] = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    //???????????????????????????????????????????????????????????

    /**
     * 将一个byte 转成一个二进制的字符串, 如果看不懂，可以参考我讲的Java基础 二进制的原码，反码，补码
     *
     * @param b    传入的 byte
     * @param flag 标志是否需要补高位如果是true ，表示需要补高位，如果是false表示不补, 如果是最后一个字节，无需补高位
     * @return 是该b 对应的二进制的字符串，（注意是按补码返回）
     */
    private static String byteToBitString(boolean flag, byte b) {
        // 使用变量保存b
        int temp = b;
        // 如果是正数还存在补高位
        if (flag) {
            temp |= 256;
        }
        String string = Integer.toBinaryString(temp);
        if (flag) {
            return string.substring(string.length() - 8);
        } else {
            return string;
        }
    }

    // 编写一个方法，将字符串对应的byte[]数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码压缩后的byte[]

    /**
     * @param bytes        这是原始的字符串对应的byte[]
     * @param huffmancodes 生成的赫夫曼编码map
     * @return 返回赫夫曼编码处理后的bytep[] 举例：String string =
     * "i like like like java do you like a java";=> byte[]contentBytes
     * 返回编码字符串对应的byte[]huffmancoideBytes,即8位对应一个bit byte[] , 即:[-88,
     * -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4,
     * -60, -90, 28]
     * <p>
     * 通俗说就是将得到的赫夫曼编码字符串再一次压缩
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmancodes) {
        // 1.利用huffmancodes将bytes转成赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmancodes.get(b));
        }
        System.out.println(stringBuilder.toString());
        // 将stringbuilder字符串按8位切割计算长度，+7为非8倍数长度加1
        int len = (stringBuilder.length() + 7) / 8;
        // 创建要存放压缩后数据的字节数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;// 记录要存放第几个元素
        for (int i = 0; i < stringBuilder.length(); i = i + 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);// 当字符串尾部元素不足8位时，将剩下元素全部放入strByte
            } else {
                strByte = stringBuilder.substring(i, i + 8);// 将第i到第i+8的元素放入strbyte
            }
            // 将strByte转换为二进制byte，放入字节数组
            // Integer.parseInt(i, 2)->10101000的补码(负数其补码为除符号位取反加1)11011000为88
            // ->(byte)88 ：88在byte的范围之内，截取位数但数值不变化
            // ->byte第一个为符号位则-88
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    // 将所有方法封装起来，便于调用
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node2> node2list = getNode(bytes);
        Node2 huffman = createHuffman(node2list);
        getCodes(huffman);
        byte[] zip = zip(bytes, huffmancodes);

        return zip;
    }

    private static List<Node2> getNode(byte[] v) {
        // 创建一个arraylist
        List<Node2> nodes = new ArrayList<>();
        HashMap<Byte, Integer> counts = new HashMap<>();
        // 遍历bytes，统计每一个byte出现的字符
        for (byte b : v) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        // 把每个键值对转成一个node对象，并加入到nodes集合
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node2(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    // 通过list创建对应的赫夫曼树
    private static Node2 createHuffman(List<Node2> nodes) {
        while (nodes.size() > 1) {
            // 排序：从小到大
            Collections.sort(nodes);
            // 取出第一第二
            Node2 leftnode = nodes.get(0);
            Node2 rightnode = nodes.get(1);
            // 创建新的二叉树,根结点没有data
            Node2 parent = new Node2(null, leftnode.weight + rightnode.weight);
            parent.left = leftnode;
            parent.right = rightnode;
            // 取出已经处理过的结点
            nodes.remove(0);
            nodes.remove(0);
            // 将新的二叉树加入
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    // 生成赫夫曼树对应的赫夫曼编码表
    // 1.将赫夫曼编码表存放在Map<Byte，String>形式
    // 2.在生成编码表时要拼接路径，定义一个stringbuilder存储某个叶子节点的路径
    static Map<Byte, String> huffmancodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * 将传入的node结点的所有叶子结点的赫夫曼编码，放到huffmnacode集合
     *
     * @param node2
     * @param code
     * @param stringBuilder
     */
    public static void getCodes(Node2 node2, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node2 != null) {// 如果结点位空不处理
            // 判断是否有数据，无数据则不是叶子结点
            if (node2.data == null) {// 非叶子结点
                // 向左递归
                getCodes(node2.left, "0", stringBuilder2);// 向左递归拼接0
                getCodes(node2.right, "1", stringBuilder2);// 向右递归拼接1
            } else {
                // 说明为叶子结点停止循环
                huffmancodes.put(node2.data, stringBuilder2.toString());
            }

        }
    }

    // 为了调用方便，我们重载 getCodes
    private static Map<Byte, String> getCodes(Node2 root) {
        if (root == null) {
            return null;
        }
        // 处理root的左子树
        getCodes(root.left, "0", stringBuilder);
        // 处理root的右子树
        getCodes(root.right, "1", stringBuilder);
        return huffmancodes;
    }
}

// 创建Node，带数据和权值
class Node2 implements Comparable<Node2> {
    Byte data;
    int weight;
    Node2 left;
    Node2 right;
    String content;

    @Override
    public int compareTo(Node2 o) {
        // TODO Auto-generated method stub
        return this.weight - o.weight;
    }

//	@Override
//	public String toString() {
//		return "Node [data=" + data + ", weight=" + weight + "]";
//	}


    @Override
    public String toString() {
        return "Node2{" +
                "weight=" + weight +
                ", content='" + content + '\'' +
                '}';
    }

    public Node2(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Node2(int weight, String content) {
        this.weight = weight;
        this.content = content;
    }

    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
