package org.dukcode.ps.codetree.trail02.chapter08.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-divide-sections-well/description">LINK</a>
 */
public class ChallengeDivideSectionsWell {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] arr;

  private static int maxVal;
  private static int total;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n];
    maxVal = Integer.MIN_VALUE;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      maxVal = Math.max(maxVal, arr[i]);
      total += arr[i];
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    for (int minSum = maxVal; minSum <= total; minSum++) {

      int cnt = 1;
      int currentSum = 0;
      for (int idx = 0; idx < n; idx++) {
        currentSum += arr[idx];
        if (currentSum > minSum) {
          cnt++;
          currentSum = arr[idx];
        }
      }

      if (cnt <= m) {
        return minSum;
      }
    }

    return total;
  }

}
