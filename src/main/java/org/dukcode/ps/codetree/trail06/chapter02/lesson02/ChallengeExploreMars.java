package org.dukcode.ps.codetree.trail06.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-explore-mars/description">LINK</a>
 */
public class ChallengeExploreMars {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] board;

  private static List<Point> basePos;
  private static int[][] baseIdx;

  private static int size;
  private static int[][] baseDist;

  private static List<Edge> edges;

  private static int[] roots;
  private static int[] ranks;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    board = new int[n][n];
    basePos = new ArrayList<>();
    baseIdx = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      Arrays.fill(baseIdx[y], -1);
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());

        if (board[y][x] == 1 || board[y][x] == 2) {
          baseIdx[y][x] = basePos.size();
          basePos.add(new Point(y, x));
        }
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    size = basePos.size();
    baseDist = new int[size][size];
    for (int i = 0; i < size; i++) {
      Arrays.fill(baseDist[i], -1);
    }

    dfsAll();

    edges = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        if (baseDist[i][j] == -1) {
          continue;
        }

        edges.add(new Edge(i, j, baseDist[i][j]));
      }
    }

    edges.sort(Comparator.comparingInt(e -> e.d));

    roots = IntStream.range(0, size).toArray();
    ranks = new int[size];

    int minDist = 0;
    for (Edge e : edges) {
      if (union(e.a, e.b)) {
        minDist += e.d;
      }
    }

    return isAllConnected() ? minDist : -1;
  }

  private static boolean isAllConnected() {
    int root = findRoot(0);
    for (int idx = 1; idx < size; idx++) {
      if (root != findRoot(idx)) {
        return false;
      }
    }

    return true;
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

  private static void dfsAll() {
    for (int baseIdx = 0; baseIdx < size; baseIdx++) {
      bfs(baseIdx);
    }
  }

  private static void bfs(int startIdx) {
    Point start = basePos.get(startIdx);

    int[][] dist = new int[n][n];
    for (int y = 0; y < n; y++) {
      Arrays.fill(dist[y], -1);
    }

    Queue<Point> q = new ArrayDeque<>();

    q.offer(start);
    dist[start.y][start.x] = 0;

    baseDist[startIdx][startIdx] = 0;

    while (!q.isEmpty()) {
      Point cur = q.poll();
      int distNow = dist[cur.y][cur.x] + 1;

      for (int dir = 0; dir < 4; dir++) {
        int ny = cur.y + DY[dir];
        int nx = cur.x + DX[dir];

        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
          continue;
        }

        if (board[ny][nx] == -1) {
          continue;
        }

        if (dist[ny][nx] != -1) {
          continue;
        }

        if (board[ny][nx] == 1 || board[ny][nx] == 2) {
          int endIdx = baseIdx[ny][nx];
          baseDist[startIdx][endIdx] = distNow;
        }

        dist[ny][nx] = distNow;
        q.offer(new Point(ny, nx));
      }
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

    int y;
    int x;

    public Point(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}
