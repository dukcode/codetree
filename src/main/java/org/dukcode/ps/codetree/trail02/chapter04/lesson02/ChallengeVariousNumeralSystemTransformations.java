package org.dukcode.ps.codetree.trail02.chapter04.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-various-numeral-system-transformations/description">LINK</a>
 */
public class ChallengeVariousNumeralSystemTransformations {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int num = Integer.parseInt(st.nextToken());
    int base = Integer.parseInt(st.nextToken());

    bw.write(convert(num, base));

    br.close();
    bw.close();

  }

  private static String convert(int num, int base) {
    if (num == 0) {
      return "0";
    }

    StringBuilder sb = new StringBuilder();

    while (num > 0) {
      sb.append(num % base);
      num /= base;
    }

    return sb.reverse().toString();
  }
}
