package org.dukcode.ps.codetree.trail04.chapter06.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-number-puzzle/description">LINK</a>
 */
public class ChallengeNumberPuzzle {

  private static final int CAP = 1_000_000_001;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n, m;
  private static int k;
  private static int[][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    bw.write(solve());

    br.close();
    bw.close();

  }

  private static String solve() {
    cache = new int[n + 1][m + 1];
    for (int[] row : cache) {
      Arrays.fill(row, -1);
    }

    return solve(n, m, 1, k);
  }

  private static String solve(int len, int sum, int lastNum, int k) {
    if (len == 1) {
      return sum + " ";
    }

    int nextLen = len - 1;
    for (int nowNum = lastNum; nowNum <= sum; nowNum++) {
      int nextSum = sum - nowNum;

      int base = nextLen * (nowNum - 1);
      int count = countWays(nextLen, nextSum - base);

      if (k > count) {
        k -= count;
        continue;
      }

      return nowNum + " " + solve(nextLen, nextSum, nowNum, k);
    }

    assert false;
    return "Impossible";
  }

  /**
   * Top-Down DP: sum을 len개의 자연수로 분할하는 경우의 수를 계산
   */
  private static int countWays(int len, int sum) {
    // Base cases
    if (len == 0 || sum < len) {
      return 0;
    }
    if (len == sum || len == 1) {
      return 1;
    }

    // Memoization check
    if (cache[len][sum] != -1) {
      return cache[len][sum];
    }

    // Recursive step (점화식: dp[i][j] = dp[i-1][j-1] + dp[i][j-i])
    int ret = countWays(len - 1, sum - 1) + countWays(len, sum - len);

    // 오버플로우 방지를 위한 CAP 적용
    return cache[len][sum] = Math.min(ret, CAP);
  }
}
