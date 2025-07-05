package org.dukcode.ps.codetree.trail04.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-non-overlapping-two-rectangles/description">LINK</a>
 */
public class ChallengeNonOverlappingTwoRectangles {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;
  private static int[][] pSum;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    pSum = new int[h + 1][w + 1];
    for (int y = 1; y <= h; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 1; x <= w; x++) {
        int upper = pSum[y - 1][x];
        int left = pSum[y][x - 1];
        int leftUpper = pSum[y - 1][x - 1];
        pSum[y][x] = upper + left - leftUpper + Integer.parseInt(st.nextToken());
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    int ret = Integer.MIN_VALUE;
    for (int y1 = 1; y1 <= h; y1++) {
      for (int x1 = 1; x1 <= w; x1++) {
        for (int y2 = y1; y2 <= h; y2++) {
          for (int x2 = x1; x2 <= w; x2++) {
            int area1 = sumSquare(y1, x1, y2, x2);

            for (int r1 = 1; r1 <= h; r1++) {
              for (int c1 = 1; c1 <= w; c1++) {
                for (int r2 = r1; r2 <= h; r2++) {
                  for (int c2 = c1; c2 <= w; c2++) {
                    if (overlap(y1, x1, y2, x2, r1, c1, r2, c2)) {
                      continue;
                    }

                    int area2 = sumSquare(r1, c1, r2, c2);
                    ret = Math.max(ret, area1 + area2);
                  }
                }
              }
            }
          }
        }
      }
    }
    return ret;
  }

  private static boolean overlap(int y1, int x1, int y2, int x2, int r1, int c1, int r2, int c2) {
    return !(y2 < r1 || x2 < c1 || r2 < y1 || c2 < x1);
  }

  private static int sumSquare(int y1, int x1, int y2, int x2) {
    return pSum[y2][x2] - pSum[y2][x1 - 1] - pSum[y1 - 1][x2] + pSum[y1 - 1][x1 - 1];
  }
}
