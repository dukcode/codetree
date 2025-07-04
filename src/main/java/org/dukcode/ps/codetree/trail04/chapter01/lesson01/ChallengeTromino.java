package org.dukcode.ps.codetree.trail04.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-tromino/description">LINK</a>
 */
public class ChallengeTromino {

  private static final int MN = -987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;
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
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    int ans = Integer.MIN_VALUE;
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        ans = Math.max(ans, maxCover(y, x));
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int maxCover(int y, int x) {
    int ret = MN;

    ret = Math.max(ret, get(y, x) + get(y - 1, x) + get(y + 1, x));
    ret = Math.max(ret, get(y, x) + get(y, x - 1) + get(y, x + 1));

    ret = Math.max(ret, get(y, x) + get(y + 1, x) + get(y, x + 1));
    ret = Math.max(ret, get(y, x) + get(y - 1, x) + get(y, x + 1));
    ret = Math.max(ret, get(y, x) + get(y + 1, x) + get(y, x - 1));
    ret = Math.max(ret, get(y, x) + get(y - 1, x) + get(y, x - 1));

    return ret;
  }

  private static int get(int y, int x) {
    if (y < 0 || y >= h || x < 0 || x >= w) {
      return MN;
    }

    return board[y][x];
  }
}
