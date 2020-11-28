package DataStructures.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;// �洢����ļ���
    private int[][] edges;// �洢ͼ��Ӧ���ڽӾ���
    private int numOfEdges;// ��ʾ�ߵ���Ŀ
    // �����������Ƿ񱻷��ʹ�
    private boolean[] isVisited = null;

    public static void main(String[] args) {
        int i = 5;
        String Vertexs[] = { "A", "B", "C", "D", "E" };
        // ����ͼ����
        Graph graph = new Graph(i);
        // ѭ����Ӷ��㣬�Ӷ�����ͼ��Ӧ���ڽӾ���
        for (String string : Vertexs) {
            graph.insertVertex(string);
        }
        // ��ӱ�(��edges��ά���������ֵ)
        // A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1);// A-B
        graph.insertEdge(0, 2, 1);// A-C
        graph.insertEdge(1, 2, 1);// B-C
        graph.insertEdge(1, 3, 1);// B-D
        graph.insertEdge(1, 4, 1);// B-E
        // ��ӡ�������ڽӾ���
        graph.showGraph();
        boolean[] isVisited = new boolean[5];

        // System.out.println("��ȱ���");
        // graph.dfs(isVisited, 3);
        graph.bfs(isVisited, 0);
    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[5];
    }

    // �õ���һ���ڽӽ����±�
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    // ����ǰһ���ڽӽ����±�����ȡ��һ���ڽӽ��
    // v2�����ڽӾ����к�����û����ͨ��·���������Ųһλ����ȡ��ǰһ���ڽӽ����ͨ����һ���ڽӽ��
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    // ������ȱ���
    public void dfs(boolean[] isVisited, int i) {

        // �Ƚ���һ�����ʵĽ�����
        System.out.print(getValueByIndex(i) + "->");
        // ������������Ϊ�Է���
        isVisited[i] = true;
        // ����i�ĵ�һ���ڽӽ��
        int w = getFirstNeighbor(i);
        // ���w��-1�����ʾ���i����û��������ͨ�Ľ�㣬�ͻ�������������ȱ���
        // �������������ɵݹ������
        // 82�еķ������þͻ��ҵ�����һ��������ȱ�����ʼ�����������ͨ��ͬ�����һ�ڽӽ�������
        // ����whileѭ�����������
        while (w != -1) {
            // ���w�����ͨ��δ�����ʹ�����wδ��ʼ������������ȱ���
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            // ����ǰ��ĵݹ��w�Ѿ����ʽ������ٻ�ȡ��ǰһ���ڽӽ����ͨ����һ���ڽӽ��
            w = getNextNeighbor(i, w);
        }
    }

    // ��dfs ����һ������, �����������еĽ�㣬������ dfs
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        System.out.println(Arrays.toString(isVisited));
        // �������еĽ�㣬����dfs[����]
        // ��ʾ�ҵ�һ��û�з��ʹ��ĵ㣬������㿪ʼ������ȱ�������
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    // ��һ�������й�����ȱ���
    public void bfs(boolean[] isVisited, int i) {
        int u;// ��ʾ������е�ͷ�����±�
        int w;// �ڽӽ��w
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(getValueByIndex(i) + "=>");
        // ��ǽ��Ϊ�ѷ���
        isVisited[i] = true;
        // �����������
        queue.addLast(i);
        while (!queue.isEmpty()) {
            // ȡ������ͷ�ڵ�
            u = queue.removeFirst();
            // �õ���һ���ڽӽ����±�w
            w = getFirstNeighbor(u);
            // ����ҵ����ڽӽ����ͨ
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "=>");
                    // ���Ϊ�Է���
                    isVisited[w] = true;
                    // ���
                    queue.addLast(w);
                }
                // ��uΪǰ������w�������һ���ڽӽ��
                w = getNextNeighbor(u, w);
            }
        }
    }

    // �������н�㣬���й����������
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    // ͼ�г��õķ���
    // ���ؽ��ĸ���
    public int getNumOfVertex() {
        return vertexList.size();
    }

    // ��ʾͼ��Ӧ�ľ���
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    // �õ��ߵ���Ŀ
    public int getNumOfEdges() {
        return numOfEdges;
    }

    // ���ؽ��i(�±�)��Ӧ������ 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    // ����v1��v2��Ȩֵ
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    // ������
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    // ��ӱ�
    /**
     * 
     * @param v1 ��ʾ����±꼴ʹ�ڼ������� "A"-"B" "A"->0 "B"->1
     * @param v2 �ڶ��������Ӧ���±�
     * @param weight ��ʾ
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
