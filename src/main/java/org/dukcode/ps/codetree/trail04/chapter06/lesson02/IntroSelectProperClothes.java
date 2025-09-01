package org.dukcode.ps.codetree.trail04.chapter06.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-select-proper-clothes/description">LINK</a>
 */
public class IntroSelectProperClothes {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] s;
  private static int[] e;
  private static int[] v;

  private static int[][] cache; // day부터 idx번째 옷을 입엇을 때 최대 화려함 (day남았을 떄가 s, e때문에 불가능. 앞의 정보 필요함)

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    s = new int[n];
    e = new int[n];
    v = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      s[i] = Integer.parseInt(st.nextToken());
      e[i] = Integer.parseInt(st.nextToken());
      v[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    cache = new int[m + 1][n];
    for (int d = 0; d <= m; ++d) {
      Arrays.fill(cache[d], -1);
    }

    int ret = 0;
    for (int idx = 0; idx < n; ++idx) {
      if (1 < s[idx] || e[idx] < 1) {
        continue;
      }

      ret = Math.max(ret, solve(1, idx));
    }

    return ret;
  }

  private static int solve(int day, int idx) {
    if (day == m) {
      return 0;
    }

    if (cache[day][idx] != -1) {
      return cache[day][idx];
    }

    int ret = 0;
    for (int nextIdx = 0; nextIdx < n; ++nextIdx) {
      int nextDay = day + 1;
      if (nextDay < s[nextIdx] || e[nextIdx] < nextDay) {
        continue;
      }

      int vDiff = Math.abs(v[idx] - v[nextIdx]);
      ret = Math.max(ret, solve(nextDay, nextIdx) + vDiff);
    }

    return cache[day][idx] = ret;
  }
}
