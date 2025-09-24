package org.dukcode.ps.codetree.trail05.chapter02.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-three-non-adjacent-numbers/description">LINK</a>
 */
public class ChallengeThreeNonAdjacentNumbers {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;
  private static int[] leftMax;
  private static int[] rightMax;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    leftMax = new int[n];
    for (int i = 0; i < n; i++) {
      leftMax[i] = Math.max(i == 0 ? 0 : leftMax[i - 1], arr[i]);
    }

    rightMax = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      rightMax[i] = Math.max(i == n - 1 ? 0 : rightMax[i + 1], arr[i]);
    }

    int ans = 0;
    for (int i = 2; i < n - 2; i++) {
      int sum = leftMax[i - 2] + arr[i] + rightMax[i + 2];
      ans = Math.max(ans, sum);
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }
}
