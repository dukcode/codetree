package org.dukcode.ps.codetree.trail05.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-move-to-the-colored-space-only-2/description">LINK</a>
 */
public class ChallengeMoveToTheColoredSpaceOnly2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;

  private static int[][] board;
  private static int min;
  private static int max;

  private static int[][] colored;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    board = new int[h][w];
    min = Integer.MAX_VALUE;
    max = Integer.MIN_VALUE;
    for (int y = 0; y < h; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < w; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
        min = Math.min(min, board[y][x]);
        max = Math.max(max, board[y][x]);
      }
    }

    colored = new int[h][w];
    for (int y = 0; y < h; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < w; x++) {
        colored[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int frIn = 0;
    int toEx = max - min + 1;

    while (frIn < toEx) {
      int mid = (frIn + toEx) / 2;
      if (isPossible(mid)) {
        toEx = mid;
      } else {
        frIn = mid + 1;
      }
    }

    return frIn;
  }

  private static boolean isPossible(int d) {
    boolean[][] vis = new boolean[h][w];

    Loop:
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        if (vis[y][x]) {
          continue;
        }

        if (colored[y][x] == 0) {
          continue;
        }

        dfs(y, x, d, vis);
        break Loop;
      }
    }

    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        if (colored[y][x] == 1 && !vis[y][x]) {
          return false;
        }
      }
    }

    return true;
  }

  private static void dfs(int y, int x, int d, boolean[][] vis) {
    vis[y][x] = true;

    final int[] DY = {0, 0, -1, 1};
    final int[] DX = {-1, 1, 0, 0};

    for (int dir = 0; dir < 4; ++dir) {
      int ny = y + DY[dir];
      int nx = x + DX[dir];

      if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
        continue;
      }

      if (vis[ny][nx]) {
        continue;
      }

      if (Math.abs(board[y][x] - board[ny][nx]) > d) {
        continue;
      }

      dfs(ny, nx, d, vis);
    }
  }
}
