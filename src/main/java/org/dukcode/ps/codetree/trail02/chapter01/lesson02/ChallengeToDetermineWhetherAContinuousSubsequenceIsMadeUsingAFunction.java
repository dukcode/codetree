package org.dukcode.ps.codetree.trail02.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-to-determine-whether-a-continuous-subsequence-is-made-using-a-function/description">LINK</a>
 */
public class ChallengeToDetermineWhetherAContinuousSubsequenceIsMadeUsingAFunction {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n1;
  private static int[] arr1;
  private static int n2;
  private static int[] arr2;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n1 = Integer.parseInt(st.nextToken());
    n2 = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    arr1 = new int[n1];
    for (int i = 0; i < n1; i++) {
      arr1[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    arr2 = new int[n2];
    for (int i = 0; i < n2; i++) {
      arr2[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(solve() ? "Yes" : "No");

    br.close();
    bw.close();

  }

  private static boolean solve() {
    for (int i = 0; i < n1; ++i) {
      if (isContinuousSub(i)) {
        return true;
      }
    }

    return false;
  }

  private static boolean isContinuousSub(int frIdx) {
    for (int idx = frIdx; idx < frIdx + n2; ++idx) {
      if (idx >= n1) {
        return false;
      }

      if (arr2[idx - frIdx] != arr1[idx]) {
        return false;
      }
    }

    return true;
  }
}
