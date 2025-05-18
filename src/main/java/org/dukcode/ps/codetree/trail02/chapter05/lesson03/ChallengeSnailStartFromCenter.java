package org.dukcode.ps.codetree.trail02.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-snail-start-from-center/description">LINK</a>
 */
public class ChallengeSnailStartFromCenter {

  // R U L D
  private static final int[] DY = {0, -1, 0, 1};
  private static final int[] DX = {1, 0, -1, 0};

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;
  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    board = new int[n][n];

    int r = n / 2;
    int c = n / 2;
    int dir = 3;
    for (int num = 1; num <= n * n; num++) {
      board[r][c] = num;

      int leftR = r + DY[(dir + 1) % 4];
      int leftC = c + DX[(dir + 1) % 4];

      int frontR = r + DY[dir];
      int frontC = c + DX[dir];

      if (outOfRange(frontR, frontC) || board[leftR][leftC] == 0) {
        dir = (dir + 1) % 4;
        r = leftR;
        c = leftC;
        continue;
      }

      r = frontR;
      c = frontC;
    }

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        bw.write(String.valueOf(board[y][x]));
        bw.write(' ');
      }
      bw.newLine();
    }
    bw.newLine();

    br.close();
    bw.close();

  }

  private static boolean outOfRange(int y, int x) {
    return y < 0 || y >= n || x < 0 || x >= n;
  }
}
