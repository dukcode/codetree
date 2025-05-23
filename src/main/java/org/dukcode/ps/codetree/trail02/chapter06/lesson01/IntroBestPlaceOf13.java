package org.dukcode.ps.codetree.trail02.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-best-place-of-13/description">LINK</a>
 */
public class IntroBestPlaceOf13 {

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

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    int maxCnt = 0;

    for (int y = 0; y < n; y++) {
      Loop:
      for (int x = 0; x < n; x++) {

        int cnt = 0;

        for (int dx = 0; dx < 3; dx++) {
          if (x + dx >= n) {
            continue Loop;
          }

          cnt += board[y][x + dx];
        }

        maxCnt = Math.max(maxCnt, cnt);

      }
    }

    return maxCnt;
  }
}
