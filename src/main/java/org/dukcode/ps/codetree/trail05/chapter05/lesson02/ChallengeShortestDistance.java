package org.dukcode.ps.codetree.trail05.chapter05.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-shortest-distance/description">LINK</a>
 */
public class ChallengeShortestDistance {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static long[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new long[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Long.parseLong(st.nextToken());
      }
    }

    for (int mid = 0; mid < n; mid++) {
      for (int y = 0; y < n; y++) {
        for (int x = 0; x < n; x++) {
          board[y][x] = Math.min(board[y][x], board[y][mid] + board[mid][x]);
        }
      }
    }

    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      bw.write(String.valueOf(board[a][b]));
      bw.newLine();
    }

    br.close();
    bw.close();
  }
}
