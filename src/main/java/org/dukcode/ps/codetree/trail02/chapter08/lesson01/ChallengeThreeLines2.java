package org.dukcode.ps.codetree.trail02.chapter08.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-three-lines-2/description">LINK</a>
 */
public class ChallengeThreeLines2 {

  private static final int X = 0;
  private static final int Y = 1;

  private static final int MN = 0;
  private static final int MX = 10;

  private static final int MX_LINE = 3;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] points;

  private static int[] taken;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    points = new int[2][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      points[X][i] = Integer.parseInt(st.nextToken());
      points[Y][i] = Integer.parseInt(st.nextToken());
    }

    taken = new int[n];
    bw.write(String.valueOf(solve(-1, 0) ? 1 : 0));

    br.close();
    bw.close();

  }

  private static boolean solve(int lastI, int cnt) {
    if (cnt == MX_LINE) {
      int numTaken = 0;
      for (int t : taken) {
        numTaken += t != 0 ? 1 : 0;
      }
      return numTaken == n;
    }

    for (int i = lastI + 1; i < 2 * (MX + 1); ++i) {
      int axis = i / (MX + 1);
      int line = i % (MX + 1);

      draw(line, axis, 1);

      if (solve(i, cnt + 1)) {
        return true;
      }

      draw(line, axis, -1);
    }

    return false;
  }

  private static void draw(int line, int axis, int delta) {
    for (int point = 0; point < n; ++point) {
      if (points[axis][point] == line) {
        taken[point] += delta;
      }
    }
  }
}
