package DataStructures.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;// 存储顶点的集合
    private int[][] edges;// 存储图对应的邻接矩阵
    private int numOfEdges;// 表示边的数目
    // 定义数组结点是否被访问过
    private boolean[] isVisited = null;

    public static void main(String[] args) {
        int i = 5;
        String Vertexs[] = { "A", "B", "C", "D", "E" };
        // 创建图对象
        Graph graph = new Graph(i);
        // 循环添加顶点，从而创建图对应的邻接矩阵
        for (String string : Vertexs) {
            graph.insertVertex(string);
        }
        // 添加边(向edges二维数组中添加值)
        // A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1);// A-B
        graph.insertEdge(0, 2, 1);// A-C
        graph.insertEdge(1, 2, 1);// B-C
        graph.insertEdge(1, 3, 1);// B-D
        graph.insertEdge(1, 4, 1);// B-E
        // 打印创建的邻接矩阵
        graph.showGraph();
        boolean[] isVisited = new boolean[5];

        // System.out.println("深度遍历");
        // graph.dfs(isVisited, 3);
        graph.bfs(isVisited, 0);
    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[5];
    }

    // 得到第一个邻接结点的下标
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    // 根据前一个邻接结点的下标来获取下一个邻接结点
    // v2点在邻接矩阵中后面再没有连通的路，所以向后挪一位，获取与前一个邻接结点连通的下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    // 深度优先遍历
    public void dfs(boolean[] isVisited, int i) {

        // 先将这一个访问的结点输出
        System.out.print(getValueByIndex(i) + "->");
        // 将这个结点设置为以访问
        isVisited[i] = true;
        // 查找i的第一个邻接结点
        int w = getFirstNeighbor(i);
        // 如果w是-1，则表示这个i索引没有与其连通的结点，就会结束这次深度优先遍历
        // 如果这个遍历是由递归而来，
        // 82行的方法调用就会找到与上一层深度优先遍历开始的索引结点连通的同层的下一邻接结点的索引
        // 并在while循环里继续遍历
        while (w != -1) {
            // 如果w结点连通且未被访问过就以w未起始结点继续进行深度遍历
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            // 进入前面的递归后w已经访问结束，再获取与前一个邻接结点连通的下一个邻接结点
            w = getNextNeighbor(i, w);
        }
    }

    // 对dfs 进行一个重载, 遍历我们所有的结点，并进行 dfs
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        System.out.println(Arrays.toString(isVisited));
        // 遍历所有的结点，进行dfs[回溯]
        // 表示找到一个没有访问过的点，从这个点开始深度优先遍历搜索
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    // 对一个结点进行广度优先遍历
    public void bfs(boolean[] isVisited, int i) {
        int u;// 表示存入队列的头结点的下标
        int w;// 邻接结点w
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(getValueByIndex(i) + "=>");
        // 标记结点为已访问
        isVisited[i] = true;
        // 将结点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()) {
            // 取出队列头节点
            u = queue.removeFirst();
            // 得到第一个邻接结点的下标w
            w = getFirstNeighbor(u);
            // 如果找到的邻接结点连通
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "=>");
                    // 标记为以访问
                    isVisited[w] = true;
                    // 入队
                    queue.addLast(w);
                }
                // 以u为前驱，找w后面的下一个邻接结点
                w = getNextNeighbor(u, w);
            }
        }
    }

    // 遍历所有结点，进行广度优先搜索
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    // 图中常用的方法
    // 返回结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    // 显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    // 得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    // 返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    // 返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    // 插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    // 添加边
    /**
     * 
     * @param v1 表示点的下标即使第几个顶点 "A"-"B" "A"->0 "B"->1
     * @param v2 第二个顶点对应的下标
     * @param weight 表示
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
