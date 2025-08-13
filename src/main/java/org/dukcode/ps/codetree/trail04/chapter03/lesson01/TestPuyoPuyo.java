package org.dukcode.ps.codetree.trail04.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-puyo-puyo/description">LINK</a>
 */
public class TestPuyoPuyo {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    board = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    PriorityQueue<Integer> pq = dfsAll();
    dfsAll();

    int cntBoom = 0;
    int maxSize = -1;
    while (!pq.isEmpty()) {
      int size = pq.poll();

      if (size >= 4) {
        cntBoom++;
      }

      maxSize = Math.max(maxSize, size);
    }
    bw.write(String.valueOf(cntBoom));
    bw.write(' ');
    bw.write(String.valueOf(maxSize));

    br.close();
    bw.close();
  }

  private static PriorityQueue<Integer> dfsAll() {
    PriorityQueue<Integer> ret = new PriorityQueue<>(Comparator.reverseOrder());

    boolean[][] vis = new boolean[n][n];
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (vis[y][x]) {
          continue;
        }

        ret.offer(dfs(y, x, vis));
      }
    }

    return ret;
  }

  private static int dfs(int y, int x, boolean[][] vis) {
    vis[y][x] = true;

    int ret = 1;
    for (int dir = 0; dir < 4; dir++) {
      int ny = y + DY[dir];
      int nx = x + DX[dir];

      if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
        continue;
      }

      if (vis[ny][nx]) {
        continue;
      }

      if (board[y][x] != board[ny][nx]) {
        continue;
      }

      ret += dfs(ny, nx, vis);
    }

    return ret;
  }
}
