package org.dukcode.ps.codetree.trail06.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-beard-tree/description">LINK</a>
 */
public class ChallengeBeardTree {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int kIdx;
  private static int[] arr;

  private static int[] parent;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());

      if (arr[i] == k) {
        kIdx = i;
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    parent = new int[n];
    parent[0] = -1;
    int parentIdx = -1;
    for (int childIdx = 1; childIdx < n; childIdx++) {
      if (arr[childIdx - 1] + 1 != arr[childIdx]) {
        parentIdx++;
      }

      parent[childIdx] = parentIdx;
    }

    int ret = 0;
    for (int idx = 0; idx < n; idx++) {
      ret += isCousin(kIdx, idx) ? 1 : 0;
    }

    return ret;
  }

  private static boolean isCousin(int aIdx, int bIdx) {
    int aParentIdx = parent[aIdx];
    int bParentIdx = parent[bIdx];

    return aParentIdx != bParentIdx && isBrother(aParentIdx, bParentIdx);
  }

  private static boolean isBrother(int aIdx, int bIdx) {
    if (aIdx == bIdx) {
      return false;
    }

    if (aIdx < 0 || bIdx < 0) {
      return false;
    }

    return parent[aIdx] == parent[bIdx];
  }
}
