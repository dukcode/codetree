package org.dukcode.ps.codetree.trail2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-find-the-greatest-common-divisor/description">LINK</a>
 */
public class ChallengeFindTheGreatestCommonDivisor {

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

    bw.write(String.valueOf(gcd(n, m)));

    br.close();
    bw.close();

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
