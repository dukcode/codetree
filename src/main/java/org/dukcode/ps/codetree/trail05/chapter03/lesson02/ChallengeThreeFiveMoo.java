package org.dukcode.ps.codetree.trail05.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-three-five-moo/description">LINK</a>
 */
public class ChallengeThreeFiveMoo {

  private static final long MX = 1_000_000_000L;

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static long n;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Long.parseLong(br.readLine());

    bw.write(String.valueOf(orderToNum(n)));

    br.close();
    bw.close();
  }

  private static long orderToNum(long order) {
    long frIn = 0;
    long toEx = 15L * MX;

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

  /**
   * 단조증가함수
   *
   * @return num 이하의 숫자 갯수
   */
  private static long numToOrder(long num) {
    return num - (num / 5) - (num / 3) + (num / 15);
  }
}
