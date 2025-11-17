package org.dukcode.ps.codetree.trail06.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-connections-on-the-grid/description">LINK</a>
 */
public class ChallengeConnectionsOnTheGrid {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static List<Edge> edges;

  private static int[] roots;
  private static int[] ranks;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    edges = new ArrayList<>();
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < m - 1; x++) {
        int w = Integer.parseInt(st.nextToken());

        Edge edge = new Edge(toIdx(y, x), toIdx(y, x + 1), w);

        edges.add(edge);
      }
    }

    for (int y = 0; y < n - 1; ++y) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < m; x++) {
        int w = Integer.parseInt(st.nextToken());

        Edge edge = new Edge(toIdx(y, x), toIdx(y + 1, x), w);

        edges.add(edge);
      }
    }

    edges.sort(Comparator.naturalOrder());

    ranks = new int[n * m];
    roots = IntStream.range(0, n * m).toArray();

    int sumWeight = 0;
    for (Edge edge : edges) {
      if (union(edge.a, edge.b)) {
        sumWeight += edge.w;
      }
    }

    bw.write(String.valueOf(sumWeight));

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

  private static int toIdx(int y, int x) {
    return y * m + x;
  }

  private static class Edge implements Comparable<Edge> {

    int a;
    int b;
    int w;

    public Edge(int a, int b, int w) {
      this.a = a;
      this.b = b;
      this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(this.w, o.w);
    }
  }

}
