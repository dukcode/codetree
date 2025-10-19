package org.dukcode.ps.codetree.trail05.chapter04.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-grid-consisting-of-0-and-1/description">LINK</a>
 */
public class ChallengeGridConsistingOf0And1 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[][] board = new int[n][n];
    for (int y = 0; y < n; y++) {
      char[] line = br.readLine().toCharArray();
      for (int x = 0; x < n; x++) {
        board[y][x] = line[x] - '0';
      }
    }

    int cnt = 0;
    for (int y = n - 1; y >= 0; --y) {
      for (int x = n - 1; x >= 0; --x) {
        if (board[y][x] == 0) {
          continue;
        }

        cnt++;
        for (int r = 0; r <= y; r++) {
          for (int c = 0; c <= x; c++) {
            board[r][c] = (board[r][c] + 1) % 2;
          }
        }
      }
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();
  }
}
