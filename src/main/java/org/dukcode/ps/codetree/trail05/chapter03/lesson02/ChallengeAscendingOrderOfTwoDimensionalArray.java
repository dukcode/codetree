package org.dukcode.ps.codetree.trail05.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-ascending-order-of-two-dimensional-array/description">LINK</a>
 */
public class ChallengeAscendingOrderOfTwoDimensionalArray {

  private static final long MX = 10_000_000_000L;

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static long n;
  private static long k;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Long.parseLong(br.readLine());
    k = Long.parseLong(br.readLine());

    bw.write(String.valueOf(orderToNum(k)));

    br.close();
    bw.close();
  }

  private static long orderToNum(long order) {
    long frIn = 1;
    long toEx = MX + 1;

    while (frIn < toEx) {
      long mid = (frIn + toEx) / 2;

      if (numToOrder(mid) < order) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }

    return frIn;
  }

  private static long numToOrder(long num) {
    long ret = 0;
    for (long i = 1; i <= n; i++) {
      ret += Math.min(n, num / i);
    }

    return ret;
  }
}
