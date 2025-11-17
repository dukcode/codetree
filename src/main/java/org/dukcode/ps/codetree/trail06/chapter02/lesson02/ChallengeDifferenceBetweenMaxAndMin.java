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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-difference-between-max-and-min/description">LINK</a>
 */
public class ChallengeDifferenceBetweenMaxAndMin {

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
      int w = Integer.parseInt(st.nextToken()) == 0 ? 1 : 0;

      edges[i] = new Edge(a, b, w);
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int minCost = mst(Comparator.comparingInt(e -> e.w));
    int maxCost = mst(Comparator.comparingInt(e -> -e.w));

    return maxCost - minCost;
  }

  private static int mst(Comparator<? super Edge> comparator) {
    roots = IntStream.range(0, n).toArray();
    ranks = new int[n];
    Arrays.sort(edges, comparator);

    int cnt = 0;
    for (Edge e : edges) {
      if (union(e.a, e.b)) {
        cnt += e.w;
      }
    }

    return cnt * cnt;
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
