package org.dukcode.ps.codetree.trail05.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-painting-the-grid-2/description">LINK</a>
 */
public class ChallengePaintingTheGrid2 {

  private static final int[] DY = {0, 0, -1, 1};
  private static final int[] DX = {-1, 1, 0, 0};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] board;
  private static int min;
  private static int max;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    board = new int[n][n];
    min = Integer.MAX_VALUE;
    max = Integer.MIN_VALUE;
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
        min = Math.min(min, board[y][x]);
        max = Math.max(max, board[y][x]);
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int frIn = 0;
    int toEx = max - min + 1;

    final int target = (n * n + 1) / 2;
    while (frIn < toEx) {
      int mid = (frIn + toEx) / 2;
      if (cntMaxColoring(mid) < target) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }

    return frIn;
  }

  private static int cntMaxColoring(int d) {
    boolean[][] vis = new boolean[n][n];
    int ret = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (vis[y][x]) {
          continue;
        }

        ret = Math.max(ret, cntColoring(y, x, vis, d));
      }
    }

    return ret;
  }

  private static int cntColoring(int y, int x, boolean[][] vis, int d) {
    vis[y][x] = true;

    int ret = 1;
    for (int dir = 0; dir < 4; ++dir) {
      int ny = y + DY[dir];
      int nx = x + DX[dir];

      if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
        continue;
      }

      if (vis[ny][nx]) {
        continue;
      }

      if (Math.abs(board[y][x] - board[ny][nx]) > d) {
        continue;
      }

      ret += cntColoring(ny, nx, vis, d);
    }

    return ret;
  }

}
