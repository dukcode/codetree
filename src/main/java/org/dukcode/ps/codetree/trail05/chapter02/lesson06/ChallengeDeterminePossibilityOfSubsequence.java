package org.dukcode.ps.codetree.trail05.chapter02.lesson06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-determine-possibility-of-subsequence/description">LINK</a>
 */
public class ChallengeDeterminePossibilityOfSubsequence {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static int[] a;
  private static int[] b;

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

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {

    int[] prefix = new int[m];
    Arrays.fill(prefix, -1);

    int aIdx = 0;
    for (int bIdx = 0; bIdx < m; ++bIdx) {
      while (aIdx < n && a[aIdx] != b[bIdx]) {
        aIdx++;
      }

      if (aIdx == n) {
        break;
      }

      prefix[bIdx] = aIdx;
      aIdx++;
    }

    int[] suffix = new int[m];
    Arrays.fill(suffix, -1);

    aIdx = n - 1;
    for (int bIdx = m - 1; bIdx >= 0; --bIdx) {
      while (aIdx >= 0 && a[aIdx] != b[bIdx]) {
        aIdx--;
      }

      if (aIdx < 0) {
        break;
      }

      suffix[bIdx] = aIdx;
      aIdx--;
    }

    int ret = 0;

    ret += suffix[1] != -1 ? 1 : 0;
    ret += prefix[m - 2] != -1 ? 1 : 0;

    for (int i = 0; i < m - 2; ++i) {
      if (prefix[i] == -1 || suffix[i + 2] == -1) {
        continue;
      }

      if (prefix[i] < suffix[i + 2]) {
        ret++;
      }
    }

    return ret;
  }
}
