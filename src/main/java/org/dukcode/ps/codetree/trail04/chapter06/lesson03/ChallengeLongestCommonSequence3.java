package org.dukcode.ps.codetree.trail04.chapter06.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-longest-common-sequence-2/description">LINK</a>
 */
public class ChallengeLongestCommonSequence3 {

  private static final int MX = 987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] a;
  private static int[] b;

  private static int[][] cache;  // LCS 길이 캐시
  private static int[][] headCache;  // 첫 원소 캐시

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    b = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }

    List<Integer> ans = solve();

    for (Integer num : ans) {
      bw.write(String.valueOf(num));
      bw.write(' ');
    }

    br.close();
    bw.close();
  }

  private static List<Integer> solve() {
    cache = new int[n][m];
    for (int[] row : cache) {
      Arrays.fill(row, -1);
    }

    headCache = new int[n][m];
    for (int[] row : headCache) {
      Arrays.fill(row, -1);
    }

    List<Integer> ret = new ArrayList<>();

    int aIdx = 0, bIdx = 0;
    while (aIdx < n && bIdx < m) {
      if (a[aIdx] == b[bIdx]) {
        ret.add(a[aIdx]);
        aIdx++;
        bIdx++;
        continue;
      }

      if (lcs(aIdx + 1, bIdx) > lcs(aIdx, bIdx + 1)) {
        aIdx++;
        continue;
      }
      if (lcs(aIdx + 1, bIdx) < lcs(aIdx, bIdx + 1)) {
        bIdx++;
        continue;
      }

      // 길이 같은 경우
      int next1 = head(aIdx + 1, bIdx);
      int next2 = head(aIdx, bIdx + 1);

      if (next1 <= next2) {
        aIdx++;
      } else {
        bIdx++;
      }
    }

    return ret;
  }

  private static int head(int aIdx, int bIdx) {
    if (aIdx >= n || bIdx >= m) {
      return MX;
    }

    if (headCache[aIdx][bIdx] != -1) {
      return headCache[aIdx][bIdx];
    }

    if (a[aIdx] == b[bIdx]) {
      return headCache[aIdx][bIdx] = a[aIdx];
    }

    if (lcs(aIdx + 1, bIdx) > lcs(aIdx, bIdx + 1)) {
      return headCache[aIdx][bIdx] = head(aIdx + 1, bIdx);
    }

    if (lcs(aIdx + 1, bIdx) < lcs(aIdx, bIdx + 1)) {
      return headCache[aIdx][bIdx] = head(aIdx, bIdx + 1);
    }

    // 같은 경우
    int next1 = head(aIdx + 1, bIdx);
    int next2 = head(aIdx, bIdx + 1);
    return headCache[aIdx][bIdx] = Math.min(next1, next2);
  }

  private static int lcs(int aIdx, int bIdx) {
    if (aIdx >= n || bIdx >= m) {
      return 0;
    }

    if (cache[aIdx][bIdx] != -1) {
      return cache[aIdx][bIdx];
    }

    if (a[aIdx] == b[bIdx]) {
      return cache[aIdx][bIdx] = 1 + lcs(aIdx + 1, bIdx + 1);
    }

    return cache[aIdx][bIdx] = Math.max(lcs(aIdx + 1, bIdx), lcs(aIdx, bIdx + 1));
  }

}
