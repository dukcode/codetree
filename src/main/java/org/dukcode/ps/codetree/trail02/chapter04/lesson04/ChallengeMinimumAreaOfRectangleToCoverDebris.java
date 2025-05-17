package org.dukcode.ps.codetree.trail02.chapter04.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimum-area-of-rectangle-to-cover-debris/description">LINK</a>
 */
public class ChallengeMinimumAreaOfRectangleToCoverDebris {

  private static final int RANGE = 1000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    board = new int[2 * RANGE + 1][2 * RANGE + 1];

    for (int i = 0; i < 2; ++i) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      for (int y = y1; y < y2; ++y) {
        for (int x = x1; x < x2; ++x) {
          board[y + RANGE][x + RANGE] = i == 0 ? 1 : 0;
        }
      }
    }

    int minX = Integer.MAX_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    int maxY = Integer.MIN_VALUE;

    boolean hasArea = false;
    for (int y = -RANGE; y <= RANGE; y++) {
      for (int x = -RANGE; x <= RANGE; x++) {
        if (board[y + RANGE][x + RANGE] == 1) {
          hasArea = true;
          minX = Math.min(minX, x);
          minY = Math.min(minY, y);
          maxX = Math.max(maxX, x);
          maxY = Math.max(maxY, y);
        }
      }
    }
    bw.write(String.valueOf(hasArea ? ((maxX - minX + 1) * (maxY - minY + 1)) : 0));
    br.close();
    bw.close();

  }
}
