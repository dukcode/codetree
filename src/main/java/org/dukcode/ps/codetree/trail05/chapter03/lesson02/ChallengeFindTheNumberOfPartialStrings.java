package org.dukcode.ps.codetree.trail05.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-find-the-number-of-partial-strings/description">LINK</a>
 */
public class ChallengeFindTheNumberOfPartialStrings {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static char[] a;
  private static int n;
  private static char[] b;
  private static int m;
  private static int[] toRemove;

  // brute force -> O(N^2) -> 40_000_000_000
  // parametric search -> O(NlgN) -> 200_000 * 21 -> 4_200_000

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    input();

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int frIn = 0;
    int toEx = n + 1;

    while (frIn < toEx) {
      int mid = (frIn + toEx) / 2;

      if (isPossible(mid)) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }

    return frIn; // 안지우는 것도 포함하므로 하나 추가
  }

  private static boolean isPossible(int order) {
    if (n - order < m) {
      return false;
    }

    boolean[] skip = new boolean[n];
    for (int i = 0; i < order; ++i) {
      skip[toRemove[i]] = true;
    }

    int bIdx = 0;
    for (int aIdx = 0; aIdx < n; ++aIdx) {
      if (skip[aIdx]) {
        continue;
      }

      if (bIdx < m && a[aIdx] == b[bIdx]) {
        bIdx++;
      }
    }

    return bIdx == m;
  }

  private static void input() throws IOException {
    a = br.readLine().toCharArray();
    n = a.length;

    b = br.readLine().toCharArray();
    m = b.length;

    toRemove = new int[a.length];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a.length; i++) {
      toRemove[i] = Integer.parseInt(st.nextToken()) - 1;
    }
  }
}
