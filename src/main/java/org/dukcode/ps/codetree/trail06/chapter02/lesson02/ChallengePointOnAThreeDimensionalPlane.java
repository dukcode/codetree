package org.dukcode.ps.codetree.trail06.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-point-on-a-three-dimensional-plane/description">LINK</a>
 */
public class ChallengePointOnAThreeDimensionalPlane {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Point[] points;

  private static List<Edge> edges;

  private static int[] roots;
  private static int[] ranks;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    points = new Point[n];
    for (int idx = 0; idx < n; idx++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int z = Integer.parseInt(st.nextToken());

      points[idx] = new Point(idx, x, y, z);
    }

    edges = new ArrayList<>();

    addEdges(Comparator.comparingInt(p -> p.x));
    addEdges(Comparator.comparingInt(p -> p.y));
    addEdges(Comparator.comparingInt(p -> p.z));

    edges.sort(Comparator.comparingInt(e -> e.d));

    roots = IntStream.range(0, n).toArray();
    ranks = new int[n];

    int sumDist = 0;
    for (Edge e : edges) {
      if (union(e.a, e.b)) {
        sumDist += e.d;
      }
    }

    bw.write(String.valueOf(sumDist));

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

  private static void addEdges(Comparator<Point> c) {
    Arrays.sort(points, c);
    for (int i = 1; i < n; i++) {
      Point a = points[i - 1];
      Point b = points[i];
      edges.add(new Edge(a.idx, b.idx, a.dist(b)));
    }
  }

  private static class Edge {

    int a;
    int b;
    int d;

    public Edge(int a, int b, int d) {
      this.a = a;
      this.b = b;
      this.d = d;
    }
  }

  private static class Point {

    int idx;
    int x;
    int y;
    int z;

    public Point(int idx, int x, int y, int z) {
      this.idx = idx;
      this.x = x;
      this.y = y;
      this.z = z;
    }

    public int dist(Point o) {
      int xDiff = Math.abs(this.x - o.x);
      int yDiff = Math.abs(this.y - o.y);
      int zDiff = Math.abs(this.z - o.z);

      return Math.min(xDiff, Math.min(yDiff, zDiff));
    }
  }
}
