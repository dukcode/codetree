package org.dukcode.ps.codetree.trail2.lesson1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-rectangle-with-a-number/description">LINK</a>
 */
public class ChallengeRectangleWithANumber {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    printSquare(n);

    br.close();
    bw.close();

  }

  private static void printSquare(int n) throws IOException {
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        int num = (y * n + x) % 9 + 1;
        bw.write(String.valueOf(num));
        bw.write(' ');
      }
      bw.newLine();
    }
    bw.newLine();
  }
}
