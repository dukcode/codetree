package org.dukcode.ps.codetree.trail2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-repeated-output/introduction">LINK</a>
 */
public class IntroRepeatedOutput {

  private static final String TEXT = "12345^&*()_";

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    printLine(n);

    br.close();
    bw.close();

  }

  private static void printLine(int times) throws IOException {
    for (int i = 0; i < times; i++) {
      bw.write(TEXT);
      bw.newLine();
    }
  }
}
