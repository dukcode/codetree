package org.dukcode.ps.codetree.trail02.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-3n-plus-1-sequence-with-recursive-function/description">LINK</a>
 */
public class Challenge3nPlus1SequenceWithRecursiveFunction {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(solve(n)));

    br.close();
    bw.close();
  }

  private static int solve(int n) {
    if (n == 1) {
      return 0;
    }

    if (n % 2 == 0) {
      return 1 + solve(n / 2);
    }

    return 1 + solve(n * 3 + 1);
  }
}
