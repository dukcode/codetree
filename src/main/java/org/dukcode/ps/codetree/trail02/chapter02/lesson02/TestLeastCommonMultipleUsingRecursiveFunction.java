package org.dukcode.ps.codetree.trail02.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-least-common-multiple-using-recursive-function/description">LINK</a>
 */
public class TestLeastCommonMultipleUsingRecursiveFunction {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(lcm(arr, 0, n)));

    br.close();
    bw.close();
  }

  private static int lcm(int[] arr, int frInIdx, int toExIdx) {
    if (frInIdx + 1 == toExIdx) {
      return arr[frInIdx];
    }

    int a = arr[frInIdx];
    int b = lcm(arr, frInIdx + 1, toExIdx);
    int gcd = 0;
    for (int i = Math.min(a, b); i > 0; --i) {
      if (a % i == 0 && b % i == 0) {
        gcd = i;
        break;
      }
    }

    return a * b / gcd;
  }
}
