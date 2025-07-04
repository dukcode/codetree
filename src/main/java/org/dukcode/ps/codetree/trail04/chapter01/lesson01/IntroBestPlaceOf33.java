package org.dukcode.ps.codetree.trail04.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-best-place-of-33/description">LINK</a>
 */
public class IntroBestPlaceOf33 {

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

    int ans = -1;
    for (int y = 0; y < n - 2; y++) {
      for (int x = 0; x < n - 2; x++) {
        ans = Math.max(ans, cntCoin(y, x));
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int cntCoin(int y, int x) {
    int ret = 0;
    for (int i = y; i < y + 3; i++) {
      for (int j = x; j < x + 3; j++) {
        ret += board[i][j];
      }
    }

    return ret;
  }
}
