package org.dukcode.ps.codetree.trail02.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-on-the-checkboard-2/description">LINK</a>
 */
public class IntroOnTheCheckboard2 {

  private static final int WHITE = 0;
  private static final int BLACK = 1;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;

  private static int[][][] cache;
  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    board = new int[h][w];
    for (int y = 0; y < h; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < w; x++) {
        int block = st.nextToken().equals("W") ? WHITE : BLACK;
        board[y][x] = block;
      }
    }

    cache = new int[3][h][w];

    for (int i = 0; i < 3; ++i) {
      for (int y = 0; y < h; y++) {
        Arrays.fill(cache[i][y], -1);
      }
    }

    bw.write(String.valueOf(solve(0, 0, 3)));

    br.close();
    bw.close();
  }

  private static int solve(int r, int c, int remainMove) {
    if (remainMove == 0) {
      if (r == h - 1 && c == w - 1) {
        return 1;
      }

      return 0;
    }

    if (cache[remainMove - 1][r][c] != -1) {
      return cache[remainMove - 1][r][c];
    }

    int ret = 0;
    for (int y = r + 1; y < h; y++) {
      for (int x = c + 1; x < w; x++) {
        if (board[y][x] == board[r][c]) {
          continue;
        }

        ret += solve(y, x, remainMove - 1);
      }
    }

    return cache[remainMove - 1][r][c] = ret;
  }
}
