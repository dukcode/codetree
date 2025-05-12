package org.dukcode.ps.codetree.trail02.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-divide-and-subtract-and-add-up/description">LINK</a>
 */
public class ChallengeDivideAndSubtractAndAddUp {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(calcResult(arr, m)));

    br.close();
    bw.close();

  }

  private static int calcResult(int[] arr, int m) {
    int ret = 0;
    while (m > 0) {
      ret += arr[m - 1];
      if (m % 2 == 0) {
        m /= 2;
      } else {
        m -= 1;
      }
    }

    return ret;
  }
}
