package org.dukcode.ps.codetree.trail02.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-group-of-pairs/description">LINK</a>
 */
public class ChallengeGroupOfPairs {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[2 * n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 2 * n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int maxPairSum = getMaxPairSum(arr, n);
    bw.write(String.valueOf(maxPairSum));

    br.close();
    bw.close();

  }

  private static int getMaxPairSum(int[] arr, int n) {
    Arrays.sort(arr);

    int maxPairSum = 0;
    for (int i = 0; i < n; ++i) {
      int a = arr[i];
      int b = arr[2 * n - 1 - i];

      maxPairSum = Math.max(maxPairSum, a + b);
    }
    return maxPairSum;
  }
}
