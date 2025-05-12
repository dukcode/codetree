package org.dukcode.ps.codetree.trail02.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-fibonacci-using-recursive-function/description">LINK</a>
 */
public class IntroFibonacciUsingRecursiveFunction {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    bw.write(String.valueOf(nthFibonacci(n)));

    br.close();
    bw.close();

  }

  private static int nthFibonacci(int n) {
    if (n == 1 || n == 2) {
      return 1;
    }

    return nthFibonacci(n - 1) + nthFibonacci(n - 2);
  }
}
