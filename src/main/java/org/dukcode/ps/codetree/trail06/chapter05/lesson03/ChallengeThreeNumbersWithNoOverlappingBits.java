package org.dukcode.ps.codetree.trail06.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-three-numbers-with-no-overlapping-bits/description">LINK</a>
 */
public class ChallengeThreeNumbersWithNoOverlappingBits {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static long[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    arr = new long[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static long solve() {
    long ret = 0L;
    for (int i = n - 1; i >= 2; i--) {
      for (int j = i - 1; j >= 1; j--) {
        for (int k = j - 1; k >= 0; k--) {
          if (arr[i] + arr[j] + arr[k] == (arr[i] | arr[j] | arr[k])) {
            ret = Math.max(ret, arr[i] + arr[j] + arr[k]);
          }
        }
      }
    }

    return ret;
  }
}
