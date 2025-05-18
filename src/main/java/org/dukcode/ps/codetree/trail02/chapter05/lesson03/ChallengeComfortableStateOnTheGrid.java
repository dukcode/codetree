package org.dukcode.ps.codetree.trail02.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-comfortable-state-on-the-grid/description">LINK</a>
 */
public class ChallengeComfortableStateOnTheGrid {

  private static final int[] DY = {-1, 0, 1, 0};
  private static final int[] DX = {0, 1, 0, -1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] board;

  private static int m;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n][n];

    int cnt = 0;
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());

      int r = Integer.parseInt(st.nextToken()) - 1;
      int c = Integer.parseInt(st.nextToken()) - 1;

      board[r][c] = 1;

      bw.write(String.valueOf(isComfortable(r, c) ? 1 : 0));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static boolean isComfortable(int r, int c) {
    int cnt = 0;
    for (int dir = 0; dir < 4; ++dir) {
      int ny = r + DY[dir];
      int nx = c + DX[dir];

      if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
        continue;
      }

      if (board[ny][nx] != 0) {
        cnt++;
      }
    }

    return cnt == 3;
  }
}
