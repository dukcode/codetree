package org.dukcode.ps.codetree.trail02.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-star-output-with-recursive-function-2/description">LINK</a>
 */
public class TestStarOutputWithRecursiveFunction2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    printStars(n);

    br.close();
    bw.close();

  }

  private static void printStars(int n) throws IOException {
    if (n == 0) {
      return;
    }

    printLine(n);
    printStars(n - 1);
    printLine(n);
  }

  private static void printLine(int n) throws IOException {
    for (int i = 0; i < n; ++i) {
      bw.write('*');
      bw.write(' ');
    }
    bw.newLine();
  }
}
