package org.dukcode.ps.codetree.trail05.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-max-rect-sum-in-grid/description">LINK</a>
 */
public class ChallengeMaxRectSumInGrid {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n; // ~ 300
  private static int[][] pSum;

  // 기존 풀이 시간 복잡도 : O(N^4) = O(300^4) = O(8_100_000_000)

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    pSum = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        int num = Integer.parseInt(st.nextToken());
        pSum[y][x] = num + (x == 0 ? 0 : pSum[y][x - 1]);
      }
    }

    int ans = Integer.MIN_VALUE;
    for (int x1 = 0; x1 < n; x1++) {
      for (int x2 = x1; x2 < n; x2++) {
        ans = Math.max(ans, maxArea(x1, x2));
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }

  // **카데인 알고리즘**
  private static int maxArea(int x1, int x2) {
    int ret = Integer.MIN_VALUE;

    int maxEndingHere = 0;
    for (int y = 0; y < n; ++y) {
      maxEndingHere += sum(x1, x2, y);
      ret = Math.max(ret, maxEndingHere);
      maxEndingHere = Math.max(0, maxEndingHere);
    }
    return ret;
  }

  private static int myMaxArea(int x1, int x2) {
    int[] dp = new int[n];

    int ret = Integer.MIN_VALUE;
    for (int y = 0; y < n; y++) {

      int sum = sum(x1, x2, y);
      ret = Math.max(ret, sum);

      dp[y] = Math.max(0, y == 0 ? 0 : dp[y - 1]) + sum;
      ret = Math.max(ret, dp[y]);
    }

    return ret;
  }

  private static int sum(int x1, int x2, int y) {
    return pSum[y][x2] - (x1 == 0 ? 0 : pSum[y][x1 - 1]);
  }
}
