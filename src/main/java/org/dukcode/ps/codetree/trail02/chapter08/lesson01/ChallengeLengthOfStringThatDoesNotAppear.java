package org.dukcode.ps.codetree.trail02.chapter08.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-length-of-string-that-does-not-appear/description">LINK</a>
 */
public class ChallengeLengthOfStringThatDoesNotAppear {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;
  private static String str;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    str = br.readLine();

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    for (int length = 1; length <= n; ++length) {

      boolean duplicated = false;
      for (int i = 0; i < n - length; ++i) {
        String subStr = str.substring(i, i + length);
        if (i != str.lastIndexOf(subStr)) {
          duplicated = true;
          break;
        }
      }

      if (!duplicated) {
        return length;
      }

    }
    return -1;
  }
}
