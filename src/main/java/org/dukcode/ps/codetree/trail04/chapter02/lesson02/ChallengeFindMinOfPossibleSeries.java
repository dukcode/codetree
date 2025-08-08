package org.dukcode.ps.codetree.trail04.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-find-min-of-possible-series/description">LINK</a>
 */
public class ChallengeFindMinOfPossibleSeries {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static char[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    arr = new char[n];
    solve(0);
    for (char c : arr) {
      bw.write(c);
    }

    br.close();
    bw.close();
  }

  private static boolean solve(int idx) {
    if (idx == n) {
      return true;
    }

    for (char c = '4'; c <= '6'; ++c) {
      arr[idx] = c;

      if (!isOk(arr, idx + 1)) {
        continue;
      }

      if (solve(idx + 1)) {
        return true;
      }
    }

    return false;
  }

  private static boolean isOk(char[] arr, int n) {
    for (int len = 1; len <= n / 2; ++len) {

      boolean same = true;
      for (int idx = 0; idx < len; ++idx) {
        if (arr[n - len + idx] != arr[n - len * 2 + idx]) {
          same = false;
          break;
        }
      }

      if (same) {
        return false;
      }
    }

    return true;
  }
}
