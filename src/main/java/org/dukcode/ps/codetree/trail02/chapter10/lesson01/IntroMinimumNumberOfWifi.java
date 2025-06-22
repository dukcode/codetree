package org.dukcode.ps.codetree.trail02.chapter10.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-minimum-number-of-wifi/description">LINK</a>
 */
public class IntroMinimumNumberOfWifi {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int cnt = solve(n, arr, m);

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }

  private static int solve(int n, int[] arr, int m) {
    int idx = 0;
    int ret = 0;
    int wifi = 2 * m + 1;
    while (idx < n) {
      if (arr[idx] == 0) {
        idx++;
        continue;
      }

      ret++;
      idx += wifi;
    }

    return ret;
  }

  // bad 풀이
  private static int getCnt(int n, int[] arr, int m) {
    if (m == 0) {
      return Arrays.stream(arr).sum();
    }

    int start = -1;
    int end = -1;
    int cnt = 0;
    for (int idx = 0; idx < n; idx++) {
      if (arr[idx] == 1 && start == -1) {
        start = idx;
        continue;
      }

      if (idx - start == 2 * m) {
        end = idx;
        start = -1;
        cnt++;
      }
    }

    if (start != -1 && end != n - 1) {
      cnt++;
    }
    return cnt;
  }
}
