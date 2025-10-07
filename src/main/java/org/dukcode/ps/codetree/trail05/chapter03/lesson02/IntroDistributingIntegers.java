package org.dukcode.ps.codetree.trail05.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-distributing-integers/description">LINK</a>
 */
public class IntroDistributingIntegers {

  private static final int MX = 100_000;

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
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int frIn = 1;
    int toEx = MX + 1;

    while (frIn < toEx) {
      int mid = (frIn + toEx) / 2;

      if (cnt(mid) >= m) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }

    return frIn - 1;
  }

  private static int cnt(int mod) {
    int ret = 0;

    for (int num : arr) {
      ret += num / mod;
    }

    return ret;
  }
}
