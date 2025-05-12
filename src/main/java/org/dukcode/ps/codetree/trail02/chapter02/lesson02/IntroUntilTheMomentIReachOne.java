package org.dukcode.ps.codetree.trail02.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-until-the-moment-I-reach-one/description">LINK</a>
 */
public class IntroUntilTheMomentIReachOne {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(countCalc(n)));

    br.close();
    bw.close();

  }

  private static int countCalc(int n) {
    if (n == 1) {
      return 0;
    }

    if (n % 2 == 0) {
      n /= 2;
    } else {
      n /= 3;
    }

    return 1 + countCalc(n);
  }
}
