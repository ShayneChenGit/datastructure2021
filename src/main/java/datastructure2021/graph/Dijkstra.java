package datastructure2021.graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dijkstra {

    public static int MAX = Integer.MAX_VALUE;

    /**
     * @param graph  图的邻接矩阵表示，MAX 表示行的下标到列的下标间没有路径存在
     * @param dist   source 到每个顶点的最短距离
     * @param n      图中一共有多少节点
     * @param source 源点的数组下标
     */
    public void solution(int[][] graph, int[] dist, int n, int source) {

        // 若 S[i]=1，则表明已经求得 source 到 i 的最短路径
        int[] S = new int[n];

        // 初始化距离，当前最短路径顶点集合S中没有任何顶点
        for (int v = 0; v < n; v++) {
            S[v] = 0;
            dist[v] = graph[source][v];
        }

        // 将源点加入最短路径顶点集合, 设置路径为0
        S[source] = 1;
        dist[source] = 0;

        // 开始主循环，每次循环，都能求得 source 到某个顶点 v 的最短路径，并将 v 加入到集合 S 中
        for (int i = 0; i < n - 1; i++) {

            // 选点，不在 S 中的顶点v，满足 dist[v] 最小
            int min = MAX;
            int v = -1;
            for (int w = 0; w < n; w++) {
                if (S[w] != 1) {
                    if (dist[w] <= min) {
                        v = w;
                        min = dist[w];
                    }
                }
            }

            // 将 v 加入 S
            S[v] = 1;

            // 更新最短距离
            for (int w = 0; w < n; w++) {
                if (S[w] != 1 && graph[v][w] < MAX && min + graph[v][w] < dist[w]) {
                    dist[w] = min + graph[v][w];
                }
            }

        }

        return;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] graph = new int[][]{
                {MAX, MAX, 10, MAX, 30, 100},
                {MAX, MAX, 5, MAX, MAX, MAX},
                {MAX, MAX, MAX, 50, MAX, MAX},
                {MAX, MAX, MAX, MAX, MAX, 10},
                {MAX, MAX, MAX, 20, MAX, 60},
                {MAX, MAX, MAX, MAX, MAX, MAX}
        };

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        int[] dist = new int[n];
        new Dijkstra().solution(graph, dist, n, 0);

        List<Integer> dList = Arrays.stream(dist).boxed().collect(Collectors.toList());
        System.out.println(dList);
    }
}
