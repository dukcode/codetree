package org.dukcode.ps.codetree.trail02.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-decimal-decisions-using-functions/description">LINK</a>
 */
public class IntroDecimalDecisionsUsingFunctions {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    bw.write(String.valueOf(sumPrimeNums(a, b)));

    br.close();
    bw.close();

  }

  private static int sumPrimeNums(int frIn, int toIn) {
    int sumPrimeNums = 0;
    for (int num = frIn; num <= toIn; num++) {
      if (isPrimeNum(num)) {
        sumPrimeNums += num;
      }
    }

    return sumPrimeNums;
  }

  private static boolean isPrimeNum(int num) {
    for (int i = 2; i * i <= num; ++i) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }
}
