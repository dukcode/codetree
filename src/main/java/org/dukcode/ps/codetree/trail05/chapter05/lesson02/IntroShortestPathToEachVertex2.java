package org.dukcode.ps.codetree.trail05.chapter05.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-shortest-path-to-each-vertex-2/description">LINK</a>
 */
public class IntroShortestPathToEachVertex2 {

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
    for (int i = 0; i < n; i++) {
      Arrays.fill(board[i], Long.MAX_VALUE);
      board[i][i] = 0;
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      long dist = Long.parseLong(st.nextToken());

      board[a][b] = Math.min(board[a][b], dist);
    }

    for (int mid = 0; mid < n; mid++) {
      for (int y = 0; y < n; y++) {
        for (int x = 0; x < n; x++) {
          if (board[y][mid] == Long.MAX_VALUE || board[mid][x] == Long.MAX_VALUE) {
            continue;
          }

          board[y][x] = Math.min(board[y][x], board[y][mid] + board[mid][x]);
        }
      }
    }

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        bw.write(String.valueOf(board[y][x] == Long.MAX_VALUE ? -1 : board[y][x]));
        bw.write(' ');
      }
      bw.newLine();
    }

    br.close();
    bw.close();
  }
}
