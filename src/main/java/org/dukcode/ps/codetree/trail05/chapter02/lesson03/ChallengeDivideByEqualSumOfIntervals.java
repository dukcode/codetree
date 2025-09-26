package org.dukcode.ps.codetree.trail05.chapter02.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-divide-by-equal-sum-of-intervals/description">LINK</a>
 */
public class ChallengeDivideByEqualSumOfIntervals {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n; // ~ 100_000
  private static long[] arr; // arr[i] : -1_000_000_000 ~ 1_000_000_000
  private static long total;

  private static long[] leftPrefixSum;
  private static long[] leftTargetCnt;

  private static long[] rightPrefixSum;
  private static long[] rightTargetCnt;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    arr = new long[n];
    total = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Long.parseLong(st.nextToken());
      total += arr[i];
    }

    leftPrefixSum = new long[n];
    leftTargetCnt = new long[n];
    for (int i = 0; i < n; i++) {
      leftPrefixSum[i] = (i == 0 ? 0 : leftPrefixSum[i - 1]) + arr[i];
      leftTargetCnt[i] =
          (i == 0 ? 0 : leftTargetCnt[i - 1]) + (leftPrefixSum[i] == total / 4 ? 1 : 0);
    }

    rightPrefixSum = new long[n];
    rightTargetCnt = new long[n];
    for (int i = n - 1; i >= 0; i--) {
      rightPrefixSum[i] = (i == n - 1 ? 0 : rightPrefixSum[i + 1]) + arr[i];
      rightTargetCnt[i] =
          (i == n - 1 ? 0 : rightTargetCnt[i + 1]) + (rightPrefixSum[i] == total / 4 ? 1 : 0);
    }

    long cnt = 0;
    for (int i = 1; i < n - 2; i++) {
      if (leftPrefixSum[i] != rightPrefixSum[i + 1]) {
        continue;
      }
      cnt += leftTargetCnt[i - 1] * rightTargetCnt[i + 2];
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();
  }
}
