package org.dukcode.ps.codetree.trail06.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-delete-edge/description">LINK</a>
 */
public class TestDeleteEdge {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static Edge[] edges;

  private static int[] roots;
  private static int[] ranks;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    edges = new Edge[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      int w = Integer.parseInt(st.nextToken());

      edges[i] = new Edge(a, b, w);
    }

    Arrays.sort(edges, Comparator.comparingInt(e -> e.w));

    roots = IntStream.range(0, n).toArray();
    ranks = new int[n];

    int maxSumWeightToRemove = 0;
    for (Edge e : edges) {
      if (!union(e.a, e.b)) {
        maxSumWeightToRemove += e.w;
      }
    }

    bw.write(String.valueOf(maxSumWeightToRemove));

    br.close();
    bw.close();
  }

  private static boolean union(int a, int b) {
    int rootA = findRoot(a);
    int rootB = findRoot(b);

    if (rootA == rootB) {
      return false;
    }

    if (ranks[rootA] < ranks[rootB]) {
      roots[rootA] = rootB;
      return true;
    } else if (ranks[rootA] > ranks[rootB]) {
      roots[rootB] = rootA;
      return true;
    }

    roots[rootB] = rootA;
    ranks[rootA]++;
    return true;
  }

  private static int findRoot(int x) {
    if (roots[x] == x) {
      return x;
    }

    return roots[x] = findRoot(roots[x]);
  }

  private static class Edge {

    int a;
    int b;
    int w;

    public Edge(int a, int b, int w) {
      this.a = a;
      this.b = b;
      this.w = w;
    }
  }
}
