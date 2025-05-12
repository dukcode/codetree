package org.dukcode.ps.codetree.trail02.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-flower-of-the-recursive-function/description">LINK</a>
 */
public class ChallengeTheFlowerOfTheRecursiveFunction {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    print(n);

    br.close();
    bw.close();

  }

  private static void print(int n) throws IOException {
    if (n == 0) {
      return;
    }

    bw.write(String.valueOf(n));
    bw.write(' ');

    print(n - 1);

    bw.write(String.valueOf(n));
    bw.write(' ');
  }
}
