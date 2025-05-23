package org.dukcode.ps.codetree.trail02.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-awkward-digits-2/description">LINK</a>
 */
public class ChallengeAwkwardDigits2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    char[] bin = br.readLine().toCharArray();
    int maxVal = Integer.MIN_VALUE;
    for (int i = 0; i < bin.length; i++) {
      bin[i] = bin[i] == '0' ? '1' : '0';
      maxVal = Math.max(maxVal, Integer.parseInt(String.valueOf(bin), 2));
      bin[i] = bin[i] == '0' ? '1' : '0';
    }

    bw.write(String.valueOf(maxVal));

    br.close();
    bw.close();

  }
}
