package org.dukcode.ps.codetree.trail02.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-star-output-with-recursive-function/description">LINK</a>
 */
public class ChallengeStarOutputWithRecursiveFunction {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    printStar(n);

    br.close();
    bw.close();

  }

  private static void printStar(int n) throws IOException {
    if (n == 0) {
      return;
    }

    printStar(n - 1);

    for (int i = 0; i < n; ++i) {
      bw.write('*');
    }
    bw.newLine();
  }
}
