package org.dukcode.ps.codetree.trail02.chapter04.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-continuously-overlapping-squares/description">LINK</a>
 */
public class TestContinuouslyOverlappingSquares {

  private static final int RANGE = 100;

  private static final int BLUE = 1;
  private static final int RED = 2;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    board = new int[2 * RANGE + 1][2 * RANGE + 1];

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int color = i % 2 == 0 ? RED : BLUE;

      for (int y = y1; y < y2; y++) {
        for (int x = x1; x < x2; x++) {
          board[y + RANGE][x + RANGE] = color;
        }
      }
    }

    int cntBlue = 0;
    for (int y = 0; y <= 2 * RANGE; y++) {
      for (int x = 0; x <= 2 * RANGE; x++) {
        if (board[y][x] == BLUE) {
          cntBlue++;
        }
      }
    }

    bw.write(String.valueOf(cntBlue));

    br.close();
    bw.close();

  }
}
