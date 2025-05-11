package org.dukcode.ps.codetree.trail02.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-an-even-number-with-a-multiple-of-5-in-the-sum/description">LINK</a>
 */
public class IntroAnEvenNumberWithAMultipleOf5InTheSum {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    bw.write(solve(n) ? "Yes" : "No");

    br.close();
    bw.close();

  }

  private static boolean solve(int n) {
    if (n % 2 != 0) {
      return false;
    }

    int digitSum = 0;
    while (n > 0) {
      digitSum += n % 10;
      n /= 10;
    }

    return digitSum % 5 == 0;
  }
}
