package DataStructures.huffmantree;

import java.util.*;

public class HuffmanCode {

    public static void main(String[] args) {
        String string = "i like like like java do you like a java";
        byte[] contenrBytes = string.getBytes();// 40λ���ȵ��ַ�byte����

        /**
         * �ֲ��� // ͳ���ַ������ֵ���ַ����ֵĴ���(Ȩֵ)���ɶ�����뼯�� List<Node2> node2list =
         * getNode(contenrBytes); System.out.println(node2list); // ���ݼ��ϴ����շ�����
         * Node2 huffman = createHuffman(node2list); System.out.println("ͷ��㣺" +
         * huffman); // getCodes(huffman, "", stringBuilder); //
         * ���ݺշ���������ÿһ��Ҷ�ӽ����ַ�ֵ��Ӧ�ĺշ������� Map<Byte, String> codes =
         * getCodes(huffman); System.out.println("�����ĺշ��������Ӧ��:" + codes);
         * System.out.println(Arrays.toString(zip(contenrBytes, huffmancodes)));
         */

        byte[] huffmanZip = huffmanZip(contenrBytes);
        System.out.println(Arrays.toString(huffmanZip));

        List<Node2> node2list = getNode(contenrBytes);
        Node2 huffman = createHuffman(node2list);
        Map<Byte, String> codes = getCodes(huffman);
        byte[] decode = decode(codes, huffmanZip);
        System.out.println("ԭ�����ַ���=" + new String(decode));


    }

    // ��дһ����������ɶ�ѹ�����ݵĽ���

    /**
     * @param huffmanCodes �շ�������� map
     * @param huffmanBytes �շ�������õ����ֽ�����
     * @return ����ԭ�����ַ�����Ӧ������
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        // 1. �ȵõ� huffmanBytes ��Ӧ�� �����Ƶ��ַ��� �� ��ʽ 1010100010111...
        StringBuilder stringBuilder = new StringBuilder();
        // ��byte����ת�ɶ����Ƶ��ַ���
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            // �ж��ǲ������һ���ֽ�
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        // ���ַ�������ָ���ĺշ���������н���
        // �Ѻշ����������е�������Ϊ�����ѯ a->100 100->a
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        // ����Ҫ�����ϣ����byte
        List<Byte> list = new ArrayList<>();
        // i �������ɾ�������,ɨ�� stringBuilder
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
        // ��forѭ������������list�оʹ�������е��ַ� "i like like like java do you like a java"
        // ��list �е����ݷ��뵽byte[] ������
        byte b[] = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    //???????????????????????????????????????????????????????????

    /**
     * ��һ��byte ת��һ�������Ƶ��ַ���, ��������������Բο��ҽ���Java���� �����Ƶ�ԭ�룬���룬����
     *
     * @param b    ����� byte
     * @param flag ��־�Ƿ���Ҫ����λ�����true ����ʾ��Ҫ����λ�������false��ʾ����, ��������һ���ֽڣ����貹��λ
     * @return �Ǹ�b ��Ӧ�Ķ����Ƶ��ַ�������ע���ǰ����뷵�أ�
     */
    private static String byteToBitString(boolean flag, byte b) {
        // ʹ�ñ�������b
        int temp = b;
        // ��������������ڲ���λ
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

    // ��дһ�����������ַ�����Ӧ��byte[]���飬ͨ�����ɵĺշ������������һ���շ�������ѹ�����byte[]

    /**
     * @param bytes        ����ԭʼ���ַ�����Ӧ��byte[]
     * @param huffmancodes ���ɵĺշ�������map
     * @return ���غշ������봦����bytep[] ������String string =
     * "i like like like java do you like a java";=> byte[]contentBytes
     * ���ر����ַ�����Ӧ��byte[]huffmancoideBytes,��8λ��Ӧһ��bit byte[] , ��:[-88,
     * -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4,
     * -60, -90, 28]
     * <p>
     * ͨ��˵���ǽ��õ��ĺշ��������ַ�����һ��ѹ��
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmancodes) {
        // 1.����huffmancodes��bytesת�ɺշ��������Ӧ���ַ���
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmancodes.get(b));
        }
        System.out.println(stringBuilder.toString());
        // ��stringbuilder�ַ�����8λ�и���㳤�ȣ�+7Ϊ��8�������ȼ�1
        int len = (stringBuilder.length() + 7) / 8;
        // ����Ҫ���ѹ�������ݵ��ֽ�����
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;// ��¼Ҫ��ŵڼ���Ԫ��
        for (int i = 0; i < stringBuilder.length(); i = i + 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);// ���ַ���β��Ԫ�ز���8λʱ����ʣ��Ԫ��ȫ������strByte
            } else {
                strByte = stringBuilder.substring(i, i + 8);// ����i����i+8��Ԫ�ط���strbyte
            }
            // ��strByteת��Ϊ������byte�������ֽ�����
            // Integer.parseInt(i, 2)->10101000�Ĳ���(�����䲹��Ϊ������λȡ����1)11011000Ϊ88
            // ->(byte)88 ��88��byte�ķ�Χ֮�ڣ���ȡλ������ֵ���仯
            // ->byte��һ��Ϊ����λ��-88
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    // �����з�����װ���������ڵ���
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node2> node2list = getNode(bytes);
        Node2 huffman = createHuffman(node2list);
        getCodes(huffman);
        byte[] zip = zip(bytes, huffmancodes);

        return zip;
    }

    private static List<Node2> getNode(byte[] v) {
        // ����һ��arraylist
        List<Node2> nodes = new ArrayList<>();
        HashMap<Byte, Integer> counts = new HashMap<>();
        // ����bytes��ͳ��ÿһ��byte���ֵ��ַ�
        for (byte b : v) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        // ��ÿ����ֵ��ת��һ��node���󣬲����뵽nodes����
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node2(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    // ͨ��list������Ӧ�ĺշ�����
    private static Node2 createHuffman(List<Node2> nodes) {
        while (nodes.size() > 1) {
            // ���򣺴�С����
            Collections.sort(nodes);
            // ȡ����һ�ڶ�
            Node2 leftnode = nodes.get(0);
            Node2 rightnode = nodes.get(1);
            // �����µĶ�����,�����û��data
            Node2 parent = new Node2(null, leftnode.weight + rightnode.weight);
            parent.left = leftnode;
            parent.right = rightnode;
            // ȡ���Ѿ�������Ľ��
            nodes.remove(0);
            nodes.remove(0);
            // ���µĶ���������
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    // ���ɺշ�������Ӧ�ĺշ��������
    // 1.���շ������������Map<Byte��String>��ʽ
    // 2.�����ɱ����ʱҪƴ��·��������һ��stringbuilder�洢ĳ��Ҷ�ӽڵ��·��
    static Map<Byte, String> huffmancodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * �������node��������Ҷ�ӽ��ĺշ������룬�ŵ�huffmnacode����
     *
     * @param node2
     * @param code
     * @param stringBuilder
     */
    public static void getCodes(Node2 node2, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node2 != null) {// ������λ�ղ�����
            // �ж��Ƿ������ݣ�����������Ҷ�ӽ��
            if (node2.data == null) {// ��Ҷ�ӽ��
                // ����ݹ�
                getCodes(node2.left, "0", stringBuilder2);// ����ݹ�ƴ��0
                getCodes(node2.right, "1", stringBuilder2);// ���ҵݹ�ƴ��1
            } else {
                // ˵��ΪҶ�ӽ��ֹͣѭ��
                huffmancodes.put(node2.data, stringBuilder2.toString());
            }

        }
    }

    // Ϊ�˵��÷��㣬�������� getCodes
    private static Map<Byte, String> getCodes(Node2 root) {
        if (root == null) {
            return null;
        }
        // ����root��������
        getCodes(root.left, "0", stringBuilder);
        // ����root��������
        getCodes(root.right, "1", stringBuilder);
        return huffmancodes;
    }
}

// ����Node�������ݺ�Ȩֵ
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

    // ǰ�����
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
