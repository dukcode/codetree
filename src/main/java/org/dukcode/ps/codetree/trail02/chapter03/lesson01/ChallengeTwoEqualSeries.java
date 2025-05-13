package org.dukcode.ps.codetree.trail02.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-two-equal-series/description">LINK</a>
 */
public class ChallengeTwoEqualSeries {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr1 = inputArr(n);
    int[] arr2 = inputArr(n);

    bw.write(hasSameElements(n, arr1, arr2) ? "Yes" : "No");
    br.close();
    bw.close();
  }

  private static boolean hasSameElements(int n, int[] arr1, int[] arr2) {
    Arrays.sort(arr1);
    Arrays.sort(arr2);

    for (int i = 0; i < n; ++i) {
      if (arr1[i] != arr2[i]) {
        return false;
      }
    }

    return true;
  }

  private static int[] inputArr(int n) throws IOException {
    int[] ret = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      ret[i] = Integer.parseInt(st.nextToken());
    }

    return ret;
  }
}
