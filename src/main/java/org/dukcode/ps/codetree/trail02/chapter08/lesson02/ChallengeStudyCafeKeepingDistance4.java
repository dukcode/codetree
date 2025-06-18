package org.dukcode.ps.codetree.trail02.chapter08.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-study-cafe-keeping-distance-4/description">LINK</a>
 */
public class ChallengeStudyCafeKeepingDistance4 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static char[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    arr = br.readLine().toCharArray();

    int ans = -1;
    for (int i = 0; i < n; i++) {
      if (arr[i] == '1') {
        continue;
      }
      for (int j = i + 1; j < n; j++) {
        if (arr[j] == '1') {
          continue;
        }

        ans = Math.max(ans, minDist(i, j));
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int minDist(int i, int j) {
    arr[i] = '1';
    arr[j] = '1';

    int ret = Integer.MAX_VALUE;

    int prev = -1;
    for (int idx = 0; idx < n; ++idx) {
      if (arr[idx] == '0') {
        continue;
      }

      if (prev == -1) {
        prev = idx;
        continue;
      }

      ret = Math.min(ret, idx - prev);
      prev = idx;
    }

    arr[i] = '0';
    arr[j] = '0';

    return ret;
  }
}
