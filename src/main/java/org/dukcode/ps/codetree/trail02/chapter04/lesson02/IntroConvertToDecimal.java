package org.dukcode.ps.codetree.trail02.chapter04.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-convert-to-decimal/description">LINK</a>
 */
public class IntroConvertToDecimal {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String binary = br.readLine();
    bw.write(String.valueOf(Integer.parseInt(binary, 2)));

    br.close();
    bw.close();

  }
}
