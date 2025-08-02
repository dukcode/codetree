package org.dukcode.ps.codetree.trail01.chapter06.lesson07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-print-star-12/description">LINK</a>
 */
public class ChallengePrintStar12 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (y == 0 || (y <= x && x % 2 == 1)) {
          bw.write("* ");
          continue;
        }

        bw.write("  ");

      }
      bw.newLine();
    }

    br.close();
    bw.close();

  }
}
