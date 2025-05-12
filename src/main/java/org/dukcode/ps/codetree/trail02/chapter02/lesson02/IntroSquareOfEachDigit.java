package org.dukcode.ps.codetree.trail02.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-square-of-each-digit/description">LINK</a>
 */
public class IntroSquareOfEachDigit {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(squareOfEachDigit(n)));

    br.close();
    bw.close();

  }

  private static int squareOfEachDigit(int n) {
    if (n == 0) {
      return 0;
    }

    int lastNum = n % 10;
    return lastNum * lastNum + squareOfEachDigit(n / 10);
  }
}
