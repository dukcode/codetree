package org.dukcode.ps.codetree.trail02.chapter04.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-decimal-and-binary-number-2/description">LINK</a>
 */
public class ChallengeDecimalAndBinaryNumber2 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String binary = br.readLine();
    bw.write(product2(binary, 17));

    br.close();
    bw.close();

  }

  private static String product2(String binary, int n) {
    return Integer.toBinaryString(Integer.parseInt(binary, 2) * n);
  }

  private static String product(String binary, int n) {
    int decimal = 0;

    for (char b : binary.toCharArray()) {
      decimal *= 2;
      decimal += b - '0';
    }

    decimal *= n;

    if (decimal == 0) {
      return "0";
    }

    StringBuilder sb = new StringBuilder();
    while (decimal > 0) {
      sb.append(decimal % 2);
      decimal /= 2;
    }

    return sb.reverse().toString();
  }
}
