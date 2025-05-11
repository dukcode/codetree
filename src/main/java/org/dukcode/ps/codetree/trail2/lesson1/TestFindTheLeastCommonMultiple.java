package org.dukcode.ps.codetree.trail2.lesson1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-find-the-least-common-multiple/description">LINK</a>
 */
public class TestFindTheLeastCommonMultiple {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;
  private static int n;
  private static int m;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    bw.write(String.valueOf(lcm(n, m)));

    br.close();
    bw.close();

  }

  private static int lcm(int a, int b) {
    return a * b / gcd(a, b);
  }

  private static int gcd(int a, int b) {
    if (a < b) {
      return gcd(b, a);
    }

    if (b == 0) {
      return a;
    }

    return gcd(b, a % b);
  }
}
