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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimum-distance/description">LINK</a>
 */
public class ChallengeMinimumDistance {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static Point[] points;

  private static int[] roots;
  private static int[] ranks;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    points = new Point[n];
    for (int idx = 0; idx < n; idx++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      points[idx] = new Point(x, y);
    }

    roots = IntStream.range(0, n).toArray();
    ranks = new int[n];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int idx1 = Integer.parseInt(st.nextToken()) - 1;
      int idx2 = Integer.parseInt(st.nextToken()) - 1;

      union(idx1, idx2);
    }

    List<Edge> edges = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (findRoot(i) != findRoot(j)) {
          edges.add(new Edge(i, j, points[i].dist(points[j])));
        }
      }
    }

    edges.sort(Comparator.comparingDouble(e -> e.dist));

    double minDist = 0;
    for (Edge edge : edges) {
      if (findRoot(edge.a) != findRoot(edge.b)) {
        minDist += edge.dist;
        union(edge.a, edge.b);
      }
    }

    bw.write(String.format("%.2f\n", minDist));

    br.close();
    bw.close();
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

    roots[rootB] = rootA;
    ranks[rootA]++;
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
    double dist;

    public Edge(int a, int b, double dist) {
      this.a = a;
      this.b = b;
      this.dist = dist;
    }
  }

  private static class Point {

    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public double dist(Point o) {
      return Math.sqrt(Math.pow(this.x - o.x, 2) + Math.pow(this.y - o.y, 2));
    }
  }
}
