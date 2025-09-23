package org.dukcode.ps.codetree.trail05.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-number-of-characters-in-the-interval/description">LINK</a>
 */
public class ChallengeTheNumberOfCharactersInTheInterval {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h; // ~ 1_000
  private static int w; // ~ 1_000
  private static int k; // ~ 100_000
  private static int[][][] pSum;

  // 예상 시간 복잡도 : O(HW + K) -> O(1_000_000 + 100_000) -> O(1_100_000)

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    pSum = new int[3][h + 1][w + 1];
    for (int y = 1; y <= h; y++) {
      String line = br.readLine();
      for (int x = 1; x <= w; x++) {
        int aIdx = line.charAt(x - 1) - 'a';

        for (int idx = 0; idx < 3; ++idx) {
          pSum[idx][y][x] = (aIdx == idx ? 1 : 0) +
              pSum[idx][y - 1][x] + pSum[idx][y][x - 1]
              - pSum[idx][y - 1][x - 1];
        }
      }
    }

    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int r1 = Integer.parseInt(st.nextToken()) - 1;
      int c1 = Integer.parseInt(st.nextToken()) - 1;
      int r2 = Integer.parseInt(st.nextToken()) - 1;
      int c2 = Integer.parseInt(st.nextToken()) - 1;

      for (int aIdx = 0; aIdx < 3; aIdx++) {
        bw.write(String.valueOf(area(aIdx, r1, c1, r2, c2)));
        bw.write(' ');
      }
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static int area(int aIdx, int y1, int x1, int y2, int x2) {
    return pSum[aIdx][y2 + 1][x2 + 1]
        - pSum[aIdx][y2 + 1][x1]
        - pSum[aIdx][y1][x2 + 1]
        + pSum[aIdx][y1][x1];
  }
}
