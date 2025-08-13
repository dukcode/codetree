package org.dukcode.ps.codetree.trail04.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-comfort-zone/description">LINK</a>
 */
public class ChallengeComfortZone {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;
  private static int[][] board;

  private static int maxH;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    board = new int[h][w];
    maxH = Integer.MIN_VALUE;
    for (int y = 0; y < h; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < w; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
        maxH = Math.max(maxH, board[y][x]);
      }
    }

    int maxCountK = 0;
    int maxCount = Integer.MIN_VALUE;
    for (int k = 1; k <= maxH; k++) {
      int cnt = dfsAll(k);
      if (maxCount < cnt) {
        maxCount = cnt;
        maxCountK = k;
      }

    }

    bw.write(String.valueOf(maxCountK));
    bw.write(' ');
    bw.write(String.valueOf(maxCount));

    br.close();
    bw.close();

  }


  private static int dfsAll(int k) {
    boolean[][] vis = new boolean[h][w];

    int ret = 0;
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        if (vis[y][x] || board[y][x] <= k) {
          continue;
        }

        ret++;
        dfs(y, x, vis, k);
      }
    }

    return ret;
  }

  private static void dfs(int y, int x, boolean[][] vis, int k) {
    vis[y][x] = true;

    for (int dir = 0; dir < 4; ++dir) {
      int ny = y + DY[dir];
      int nx = x + DX[dir];

      if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
        continue;
      }

      if (vis[ny][nx]) {
        continue;
      }

      if (board[ny][nx] <= k) {
        continue;
      }

      dfs(ny, nx, vis, k);
    }
  }
}
