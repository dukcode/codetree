package org.dukcode.ps.codetree.trail02.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-snail-alphabet-square/description">LINK</a>
 */
public class ChallengeSnailAlphabetSquare {

  // R D L U
  private static final int[] DY = {0, 1, 0, -1};
  private static final int[] DX = {1, 0, -1, 0};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;
  private static char[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());
    board = new char[h][w];

    int r = 0;
    int c = 0;
    int dir = 0;
    for (int idx = 0; idx < h * w; idx++) {
      board[r][c] = (char) ('A' + idx % 26);

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
        bw.write(board[y][x]);
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
