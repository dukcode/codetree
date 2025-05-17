package org.dukcode.ps.codetree.trail02.chapter04.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-convert-to-binary/description">LINK</a>
 */
public class IntroConvertToBinary {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int decimal = Integer.parseInt(br.readLine());
    bw.write(toBinary(decimal));

    br.close();
    bw.close();

  }

  private static String toBinary(int decimal) {
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
