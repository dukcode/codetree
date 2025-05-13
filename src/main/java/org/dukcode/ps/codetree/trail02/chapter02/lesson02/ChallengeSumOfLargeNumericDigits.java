package org.dukcode.ps.codetree.trail02.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sum-of-large-numeric-digits/description">LINK</a>
 */
public class ChallengeSumOfLargeNumericDigits {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    bw.write(String.valueOf(sumOfDigits(a * b * c)));

    br.close();
    bw.close();

  }

  private static int sumOfDigits(int n) {
    if (n == 0) {
      return 0;
    }

    return n % 10 + sumOfDigits(n / 10);
  }
}
