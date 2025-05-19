package org.dukcode.ps.codetree.trail02.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-pair-parentheses-3/description">LINK</a>
 */
public class IntroPairParentheses3 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    char[] input = br.readLine().toCharArray();
    int cnt = 0;
    for (int i = 0; i < input.length; i++) {
      if (input[i] == ')') {
        continue;
      }
      for (int j = i + 1; j < input.length; j++) {
        if (input[j] == ')') {
          cnt++;
        }
      }
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }
}
