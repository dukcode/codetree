package org.dukcode.ps.codetree.trail06.chapter02.lesson01;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimum-edge-size/description">LINK</a>
 */
public class ChallengeMinimumEdgeSize {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static int a;
  private static int b;

  private static Edge[] edges;

  private static int[] ranks;
  private static int[] roots;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken()) - 1;
    b = Integer.parseInt(st.nextToken()) - 1;

    ranks = new int[n];
    roots = IntStream.range(0, n).toArray();

    edges = new Edge[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      int satisfying = Integer.parseInt(st.nextToken());

      edges[i] = new Edge(a, b, satisfying);
    }

    Arrays.sort(edges, Comparator.comparingInt(e -> -e.satisfying));

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    for (int i = 0; i < m; i++) {
      int x = edges[i].a;
      int y = edges[i].b;
      int satisfying = edges[i].satisfying;

      union(x, y);

      if (areInSameSet(a, b)) {
        return satisfying;
      }
    }

    return -1;
  }

  private static boolean areInSameSet(int a, int b) {
    return findRoot(a) == findRoot(b);
  }

  private static void union(int a, int b) {
    int rootA = findRoot(a);
    int rootB = findRoot(b);

    if (rootA == rootB) {
      return;
    }

    if (ranks[rootA] < ranks[rootB]) {
      roots[rootA] = rootB;
      return;
    } else if (ranks[rootA] > ranks[rootB]) {
      roots[rootB] = rootA;
      return;
    }

    roots[rootA] = rootB;
    ranks[rootB]++;
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
    int satisfying;

    public Edge(int a, int b, int satisfying) {
      this.a = a;
      this.b = b;
      this.satisfying = satisfying;
    }
  }
}
