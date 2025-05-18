package org.dukcode.ps.codetree.trail02.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-snail-number-square-2/description">LINK</a>
 */
public class ChallengeSnailNumberSquare2 {

  // D R U L
  private static final int[] DY = {1, 0, -1, 0};
  private static final int[] DX = {0, 1, 0, -1};

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

    int r = 0;
    int c = 0;
    int dir = 0;
    for (int num = 1; num <= h * w; num++) {
      board[r][c] = num;

      int ny = r + DY[dir];
      int nx = c + DX[dir];

      if (outOfRange(ny, nx) || board[ny][nx] != 0) {
        dir = (dir + 1) % 4;
      }

      r += DY[dir];
      c += DX[dir];
    }

    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
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
    return y < 0 || y >= h || x < 0 || x >= w;
  }
}
