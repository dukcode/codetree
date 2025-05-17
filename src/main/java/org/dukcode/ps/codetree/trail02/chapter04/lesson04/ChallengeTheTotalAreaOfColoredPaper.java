package org.dukcode.ps.codetree.trail02.chapter04.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-total-area-of-colored-paper/description">LINK</a>
 */
public class ChallengeTheTotalAreaOfColoredPaper {

  private static final int RANGE = 100;

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
      int fx = Integer.parseInt(st.nextToken());
      int fy = Integer.parseInt(st.nextToken());

      for (int y = fy; y < fy + 8; y++) {
        for (int x = fx; x < fx + 8; x++) {
          board[y + RANGE][x + RANGE] = 1;
        }
      }
    }

    int area = 0;
    for (int[] line : board) {
      area += Arrays.stream(line).sum();
    }

    bw.write(String.valueOf(area));

    br.close();
    bw.close();

  }
}
