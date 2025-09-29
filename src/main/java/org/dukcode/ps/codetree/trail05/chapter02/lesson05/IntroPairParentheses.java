package org.dukcode.ps.codetree.trail05.chapter02.lesson05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-pair-parentheses/description">LINK</a>
 */
public class IntroPairParentheses {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static char[] line;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    line = br.readLine().toCharArray();
    int n = line.length;

    long ans = 0;
    int open = 0;
    for (int i = 1; i < n; i++) {
      if (line[i] == '(' && line[i - 1] == '(') {
        open++;
        continue;
      }

      if (line[i] == ')' && line[i - 1] == ')') {
        ans += open;
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }
}
