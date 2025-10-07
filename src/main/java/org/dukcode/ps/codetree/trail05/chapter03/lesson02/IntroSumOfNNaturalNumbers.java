package org.dukcode.ps.codetree.trail05.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-sum-of-n-natural-numbers/description">LINK</a>
 */
public class IntroSumOfNNaturalNumbers {

  private static final long MX = 2_000_000_000L;

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static long s; // ~ 10^18

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    s = Long.parseLong(br.readLine());

    bw.write(String.valueOf(solve(s)));

    br.close();
    bw.close();
  }

  private static long solve(long target) {
    return upperBound(target) - 1;
  }

  private static long upperBound(long target) {
    long frIn = 1;
    long toEx = MX;

    while (frIn < toEx) {
      long mid = (frIn + toEx) / 2;

      if (sum(mid) <= target) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }
    return frIn;
  }

  private static long sum(long n) {
    return n * (n + 1) / 2;
  }

}
