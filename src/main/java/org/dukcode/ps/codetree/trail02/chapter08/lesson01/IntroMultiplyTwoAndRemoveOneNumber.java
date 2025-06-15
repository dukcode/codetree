package org.dukcode.ps.codetree.trail02.chapter08.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-multiply-two-and-remove-one-number/description">LINK</a>
 */
public class IntroMultiplyTwoAndRemoveOneNumber {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int ans = Integer.MAX_VALUE;
    for (int doubleIdx = 0; doubleIdx < n; doubleIdx++) {
      arr[doubleIdx] *= 2;
      for (int delIdx = 0; delIdx < n; delIdx++) {
        ans = Math.min(ans, sumDiff(delIdx));
      }

      arr[doubleIdx] /= 2;
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int sumDiff(int delIdx) {
    int ret = 0;
    for (int i = 1; i < n; ++i) {
      if (i == delIdx) {
        continue;
      }

      if (i == 1 && delIdx == 0) {
        continue;
      }

      int now = arr[i];
      int before = i - 1 == delIdx ? arr[i - 2] : arr[i - 1];

      ret += Math.abs(now - before);
    }

    return ret;
  }

  public static int sumDiff2(int delIdx) {
    int ret = 0;

    int prev = -1;
    for (int i = 0; i < n; i++) {
      if (i == delIdx) {
        continue;
      }

      int now = arr[i];
      if (prev != -1) {
        ret += Math.abs(now - prev);
      }

      prev = now;
    }

    return ret;
  }
}
