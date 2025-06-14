package org.dukcode.ps.codetree.trail02.chapter07.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-arithmetic-sequence/description">LINK</a>
 */
public class ChallengeArithmeticSequence {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;

  private static int max;
  private static int min;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    max = Integer.MIN_VALUE;
    min = Integer.MAX_VALUE;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }

    int maxCnt = 0;
    for (int k = min + 1; k < max; k++) {
      maxCnt = Math.max(maxCnt, cnt(k));
    }

    bw.write(String.valueOf(maxCnt));

    br.close();
    bw.close();

  }

  private static int cnt(int k) {
    int cnt = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        if (k - arr[i] == arr[j] - k) {
          cnt++;
        }
      }
    }

    return cnt;
  }
}
