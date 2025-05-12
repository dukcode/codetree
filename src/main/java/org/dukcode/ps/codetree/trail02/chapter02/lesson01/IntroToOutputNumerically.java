package org.dukcode.ps.codetree.trail02.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-to-output-numerically/description">LINK</a>
 */
public class IntroToOutputNumerically {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    printIncrease(n);
    bw.newLine();
    printDecrease(n);
    bw.newLine();

    br.close();
    bw.close();

  }

  private static void printIncrease(int n) throws IOException {
    if (n == 0) {
      return;
    }

    printIncrease(n - 1);

    bw.write(String.valueOf(n));
    bw.write(' ');
  }

  private static void printDecrease(int n) throws IOException {
    if (n == 0) {
      return;
    }

    bw.write(String.valueOf(n));
    bw.write(' ');

    printDecrease(n - 1);
  }
}
