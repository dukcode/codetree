package org.dukcode.ps.codetree.trail05.chapter05.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-move-to-another-parenthesis/description">LINK</a>
 */
public class ChallengeMoveToAnotherParenthesis {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int a; // 같을 때
  private static int b; // 다를 때

  private static char[][] board;

  private static int[][][] cost;

  private static int ans;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

    board = new char[n][];
    for (int y = 0; y < n; y++) {
      board[y] = br.readLine().toCharArray();
    }

    cost = new int[n * n][n][n];
    for (int idx = 0; idx < n * n; idx++) {
      for (int x = 0; x < n; x++) {
        Arrays.fill(cost[idx][x], Integer.MAX_VALUE);
      }
    }

    ans = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        dijkstra(y, x);
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }

  private static void dijkstra(int y, int x) {
    boolean[][] vis = new boolean[n][n];

    int idx = n * y + x;
    cost[idx][y][x] = 0;

    PriorityQueue<Path> pq = new PriorityQueue<>();
    pq.offer(new Path(y, x, 0));

    while (!pq.isEmpty()) {
      Path cur = pq.poll();
      if (vis[cur.y][cur.x]) {
        continue;
      }

      vis[cur.y][cur.x] = true;
      ans = Math.max(ans, cost[idx][cur.y][cur.x]);

      for (int dir = 0; dir < 4; ++dir) {
        int ny = cur.y + DY[dir];
        int nx = cur.x + DX[dir];

        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
          continue;
        }

        boolean same = board[cur.y][cur.x] == board[ny][nx];
        int nCost = cur.cost + (same ? a : b);

        if (cost[idx][ny][nx] <= nCost) {
          continue;
        }

        cost[idx][ny][nx] = nCost;
        pq.offer(new Path(ny, nx, nCost));
      }
    }
  }

  private static class Path implements Comparable<Path> {

    int y;
    int x;
    int cost;

    public Path(int y, int x, int cost) {
      this.y = y;
      this.x = x;
      this.cost = cost;
    }

    @Override
    public int compareTo(Path o) {
      return Integer.compare(cost, o.cost);
    }
  }
}
