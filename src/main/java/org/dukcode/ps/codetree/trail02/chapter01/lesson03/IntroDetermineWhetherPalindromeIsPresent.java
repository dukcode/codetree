package org.dukcode.ps.codetree.trail02.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-determine-whether-palindrome-is-present/description">LINK</a>
 */
public class IntroDetermineWhetherPalindromeIsPresent {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String word = br.readLine();

    bw.write(isPalindrome(word) ? "Yes" : "No");

    br.close();
    bw.close();

  }

  private static boolean isPalindrome(String word) {
    int n = word.length();
    for (int i = 0; i < n / 2; i++) {
      if (word.charAt(i) != word.charAt(n - 1 - i)) {
        return false;
      }
    }

    return true;
  }
}
