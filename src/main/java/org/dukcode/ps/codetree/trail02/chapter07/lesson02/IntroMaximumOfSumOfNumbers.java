package org.dukcode.ps.codetree.trail02.chapter07.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-maximum-of-sum-of-numbers/description">LINK</a>
 */
public class IntroMaximumOfSumOfNumbers {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    bw.write(String.valueOf(maxSumDigitsBetween(a, b)));

    br.close();
    bw.close();

  }

  private static int maxSumDigitsBetween(int frIn, int toIn) {
    int ret = 0;

    for (int num = frIn; num <= toIn; ++num) {
      ret = Math.max(ret, sumDigits(num));
    }

    return ret;
  }

  private static int sumDigits(int num) {
    int ret = 0;
    while (num > 0) {
      ret += num % 10;
      num /= 10;
    }

    return ret;
  }
}
